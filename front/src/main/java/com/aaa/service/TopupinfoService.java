package com.aaa.service;

import com.aaa.dao.FrontuserDao;
import com.aaa.dao.TopupinfoDao;
import com.aaa.entity.FrontUser;
import com.aaa.entity.Topupinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public void panduan(String tpid) {
        Map<String, Object> map = topupinfoDao.show(tpid, null, null).get(0);

        FrontUser frontUser = frontuserDao.selectByPrimaryKey(map.get("front_userid"));
        System.out.println(map);
        if (map.get("tstype").equals("0")) {
            //会员
            //判断用户的时间，修改用户的会员时间
            if (frontUser.getFront_uservipoutdata() != null) {
                if (frontUser.getFront_uservipoutdata().compareTo(new Date()) > 0) {
                    //用户vip到期时间大于当前时间
                }
            }
            //用户vip到期时间小于当前时间，获取当前字段是null值

        } else if (map.get("tstype").equals("1")) {
            //虚拟币充值
            //用户当前的虚拟币做添加
            Integer zo = frontUser.getFront_usermoney() + Integer.parseInt(map.get("tscustom").toString());
            FrontUser f2 = new FrontUser();
            f2.setFront_userid(frontUser.getFront_userid());
            f2.setFront_usermoney(zo);
            frontuserDao.updates(f2);

        }
    }

    ;

}
