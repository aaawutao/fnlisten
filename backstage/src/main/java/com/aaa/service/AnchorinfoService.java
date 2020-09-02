package com.aaa.service;

import com.aaa.dao.AnchorinfoDao;
import com.aaa.entity.Anchorinfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnchorinfoService {

    @Resource
    AnchorinfoDao anchorinfoDao;

    public int addAnchorinfo(Anchorinfo anchorinfo){
        return  anchorinfoDao.insert(anchorinfo);
    }

    public List<Anchorinfo> queryAllByacid(Integer bfid){
        return  anchorinfoDao.queryAllByacid(bfid);
    }
}
