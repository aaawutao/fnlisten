package com.aaa.service;

import com.aaa.dao.ProgramtypeinfoDao;
import com.aaa.entity.Programtypeinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProgramtypeinfoService {
    @Resource
    ProgramtypeinfoDao programtypeinfoDao;

    public List<Programtypeinfo> show() {
        return programtypeinfoDao.selectAll();
    }
}
