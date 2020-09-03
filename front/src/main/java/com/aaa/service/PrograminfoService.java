package com.aaa.service;

import com.aaa.dao.PrograminfoDao;
import com.aaa.entity.Programinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PrograminfoService {
    @Resource
    PrograminfoDao programinfoDao;

    public List<Map<String,Object>> query(Integer pid,Integer ptid,Integer anchortid,Integer num){
        return programinfoDao.query(pid,ptid,anchortid,num);
    }
}
