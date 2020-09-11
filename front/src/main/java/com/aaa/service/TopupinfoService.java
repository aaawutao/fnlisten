package com.aaa.service;

import com.aaa.dao.FrontuserDao;
import com.aaa.dao.TopupinfoDao;
import com.aaa.entity.FrontUser;
import com.aaa.entity.Topupinfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TopupinfoService {

    @Resource
    TopupinfoDao topupinfoDao;
    @Resource
    FrontuserDao frontuserDao;

    //充值记录
    public List<Map<String, Object>> query(Integer front_userid, Integer order) {
        return topupinfoDao.show(null, front_userid, order);
    }

    public Integer add(Topupinfo topupinfo) {
        return topupinfoDao.insert(topupinfo);
    }

    //修改状态
    public Integer editState(String tpid, String paymentid) {
        return topupinfoDao.editState(tpid, paymentid);
    }
    //修改成功之后的调用方法
    public void panduan(String tpid, HttpSession session) {
        Map<String, Object> map = topupinfoDao.show(tpid, null, null).get(0);
        FrontUser frontUser = frontuserDao.selectByPrimaryKey(map.get("front_userid"));
        if (map.get("tstype").toString().equals("0")) {
            //虚拟币充值
            //用户当前的虚拟币做添加
            Integer zo = frontUser.getFront_usermoney() + Integer.parseInt(map.get("tscustom").toString());
            FrontUser f2 = new FrontUser();
            f2.setFront_userid(frontUser.getFront_userid());
            f2.setFront_usermoney(zo);
            frontuserDao.updates(f2);
        } else if (map.get("tstype").toString().equals("1")) {
            Date newDate=null;
            //会员
            //判断用户的时间，修改用户的会员时间
            if (frontUser.getFront_uservipoutdata() != null) {
                if (frontUser.getFront_uservipoutdata().compareTo(new Date()) > 0) {
                    //用户vip到期时间大于当前时间
                   newDate=this.setDate(map.get("tscustom").toString(),frontUser.getFront_uservipoutdata());
                }else{
                    newDate=this.setDate(map.get("tscustom").toString(),new Date());
                }
            }else{
                newDate=this.setDate(map.get("tscustom").toString(),new Date());
            }
            FrontUser f3 = new FrontUser();
            f3.setFront_userid(frontUser.getFront_userid());
            f3.setFront_uservipoutdata(newDate);
            f3.setFront_userstate(2);
            frontuserDao.updates(f3);
        }
        //当支付成功之后修改session
        session.setAttribute("user",frontuserDao.login(frontUser.getFront_userphone(),frontUser.getFront_userpwd()));
    }

    //判断时间做处理
    public Date setDate(String tianshu,Date userDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(userDate);
        switch (tianshu){
            case "一个月":
                cal.add(Calendar.MONTH, 1);
                break;
            case "三个月":
                cal.add(Calendar.MONTH, 3);
                break;
            case "半年":
                cal.add(Calendar.MONTH, 6);
                break;
            case "一年":
                cal.add(Calendar.YEAR, 1);
                break;
        }
        return cal.getTime();
    }


    //查询用户充值记录
   public  PageInfo<List<Map<String, Object>>> queryByuserRecord(Integer page,Integer size,Integer front_userid) {
       PageHelper.startPage(page, size);
       List<Map<String, Object>> list = topupinfoDao.queryByuserRecord(front_userid);
       PageInfo<List<Map<String, Object>>> pageInfo = new PageInfo(list);
       return pageInfo;
   }
}
