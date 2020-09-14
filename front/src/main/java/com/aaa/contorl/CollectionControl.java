package com.aaa.contorl;

import com.aaa.entity.Collection;
import com.aaa.service.CollectionService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("collection")
public class CollectionControl {

    @Resource
    CollectionService collectionService;

    @RequestMapping("add")
    @ResponseBody
    public Integer add(Collection collection){
        return collectionService.add(collection);
    }
    @RequestMapping("del")
    @ResponseBody
    public Integer del(Integer front_userid,Integer pid){
        return collectionService.del(front_userid,pid);
    }
}
