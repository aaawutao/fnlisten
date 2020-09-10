package com.aaa.service;

import com.aaa.dao.ChapterinfoDao;
import com.aaa.entity.Chapterinfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;
import java.util.List;

@Service
public class ChapterinfoService {
    @Resource
    ChapterinfoDao chapterinfoDao;

    public List<Map<String, Object>> queryChapter(Integer pid) {
        return chapterinfoDao.queryChapter(pid);
    }
    public Integer add(Chapterinfo chapterinfo) {
        return chapterinfoDao.insert(chapterinfo);
    }

}
