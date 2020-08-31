package com.aaa.service;

import com.aaa.dao.ChapterinfoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.List;

@Service
public class ChapterinfoService {
    @Resource
    ChapterinfoDao chapterinfoDao;

    public List<Map<String,Object>> queryChapter(Integer pid){
        return  chapterinfoDao.queryChapter(pid);
    }
}
