package com.aaa.service;

import com.aaa.dao.AnchorinfoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.List;

@Service
public class AnchorinfoService {
    @Resource
    AnchorinfoDao anchorinfoDao;

    public List<Map<String, Object>> query(Integer actype, Integer num) {
        return anchorinfoDao.query(actype, num);
    }

    public int addanchor(Integer front_userid, String petname) {
        return anchorinfoDao.addanchor(front_userid, petname);
    }

    public  int updatepetname(String petname, Integer bfid){
        return  anchorinfoDao.updatePetname(petname,bfid);
    }

}
