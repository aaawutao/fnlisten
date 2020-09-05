package com.aaa.service;

import com.aaa.dao.ChapterinfoDao;
import com.aaa.entity.Chapterinfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ChapterinfoService {

    @Resource
    ChapterinfoDao chapterinfoDao;

    public List<Chapterinfo> querychapBypid(Integer pid){

        return  chapterinfoDao.querychapBypid(pid);
    }

    //添加
    public int addchapter(Chapterinfo chapterinfo){
        return  chapterinfoDao.insert(chapterinfo);
    }

}
