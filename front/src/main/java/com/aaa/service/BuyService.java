package com.aaa.service;

import com.aaa.dao.BuyDao;
import com.aaa.dao.FrontuserDao;
import com.aaa.dao.PrograminfoDao;
import com.aaa.entity.Buy;
import com.aaa.entity.FrontUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;


@Service
@Transactional
public class BuyService {
    @Resource
    BuyDao buyDao;
    @Resource
    FrontuserDao frontuserDao;

    @Resource
    PrograminfoDao programinfoDao;

    public boolean buycheck(Integer userid,Integer pid,Integer ctid){
        Buy qbbuy=buyDao.query(userid,pid,0);
        if(qbbuy!=null){
            return  true;
        }
        Buy zjbuy=buyDao.query(userid,pid,ctid);
        if(zjbuy!=null){
            return true;
        }
        return false;
    }

    public Integer buyprogram(Integer userid,Integer pid,Integer ctid,Integer zhifumoney){
        try {
            Buy buy=new Buy();
            buy.setPurchaser(userid);
            buy.setPid(pid);
            buy.setCtid(pid);
            buy.setPurchaservc(zhifumoney);
            //折合人民币
            Double money=Double.valueOf(zhifumoney/10);
            buy.setPurchasermoney(money);

            //设置世界
            buy.setBuydate(new Date());

            //用户所拥有的虚拟币做修改 -支付懒人币
            FrontUser frontUser=new FrontUser();
            frontUser.setFront_userid(userid);
            frontUser.setFront_usermoney(zhifumoney);
            //用户虚拟币做修改
            Integer res=frontuserDao.updates(frontUser);
            System.out.println("虚拟币修改"+res);
            //购买力修改
            res=programinfoDao.updateBuycount(pid);
            System.out.println("购买力修改"+res);
            //使用节目编号找到主播
            Map<String,Object> map=programinfoDao.query(pid,null,null,null).get(0);
            System.out.println(map);
            //主播找到关联的用户
            if(map.get("actype").toString().equals("0")){
                //后台 主播我们的
                System.out.println("后台主播");
                //只设置分红利益
                buy.setAcquireeparticipation(money);
                //设置
            }else {
                //前台 用户10%的利益

                //设置用户主播的现有金额
                //使用主播编号获取用户的金额
                FrontUser frontUser1=frontuserDao.selectByPrimaryKey(Integer.valueOf(map.get("bfid").toString()));
                buy.setAcquiree_original_money(frontUser1.getFront_userwd());

                //分红金额
                buy.setAcquireeparticipation(money/2);

                //用户的总提现金额
                Double zomoney=frontUser1.getFront_userwd()+(money-(money/2));
                buy.setAcquiree_now_money(zomoney);

                FrontUser frontUser3=new FrontUser();
                //修改用户的提现金额
                frontUser3.setFront_userid(frontUser1.getFront_userid());
                frontUser3.setFront_userwd(buy.getAcquiree_now_money());
                frontuserDao.updates(frontUser3);
            }
            //做添加
            buyDao.insert(buy);
            return 1;
        } catch (Exception e) {
            //强制手动事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }


    }
}
