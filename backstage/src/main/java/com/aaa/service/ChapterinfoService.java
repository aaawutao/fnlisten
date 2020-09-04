package com.aaa.service;

import com.aaa.dao.ChapterinfoDao;
import com.aaa.entity.Chapterinfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ChapterinfoService {

    @Resource
    ChapterinfoDao chapterinfoDao;

    public PageInfo<Chapterinfo> findAll(Integer currentPage, Integer pageSize,Integer pid){
        PageHelper.startPage(currentPage,pageSize);
        List<Chapterinfo> userall = chapterinfoDao.queryAll(pid);
        PageInfo<Chapterinfo> pageInfo = new PageInfo<>(userall);
        return pageInfo;
    }

    //添加
    public int addchapter(Chapterinfo chapterinfo){
        return  chapterinfoDao.insert(chapterinfo);
    }

}
