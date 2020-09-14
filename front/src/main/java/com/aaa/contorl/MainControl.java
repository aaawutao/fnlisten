package com.aaa.contorl;

import com.aaa.dao.PrograminfoDao;
import com.aaa.entity.Programinfo;
import com.aaa.entity.Programtypeinfo;
import com.aaa.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class MainControl {
    @Resource
    PrograminfoService programinfoService;
    @Resource
    ChapterinfoService chapterinfoService;

    @Resource
    ProgramtypeinfoService programtypeinfoService;
    @Resource
    AnchorinfoService anchorinfoService;

    @Resource
    TopupsetinfoService topupsetinfoService;

    //充值记录
    @Resource
    TopupinfoService topupinfoService;
    //购买记录
    @Resource
    BuyService buyService;

    //主页
    @RequestMapping("/main")
    public String show() {
        return "main.html";
    }

    //登录
    @RequestMapping("/login")
    public String test(@RequestParam("flag") Integer flag, ModelMap modelMap) {
        modelMap.addAttribute("flag", flag);
        return "login.html";
    }
    //虚拟币充值
    @RequestMapping("/xunibirecharge")
    public String recharge(ModelMap modelMap) {
        modelMap.addAttribute("chongzhi", topupsetinfoService.query(0));
        return "xunibirecharge.html";
    }
    //vip充值
    @RequestMapping("/viprecharge")
    public String viprecharge(ModelMap modelMap) {
        modelMap.addAttribute("chongzhi", topupsetinfoService.query(1));
        return "viprecharge.html";
    }
    //显示所有节目
    @RequestMapping("/programtypedetails")
    public String programtypedetails(ModelMap model,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue ="8") Integer size, @RequestParam(defaultValue ="1")Integer ptid) {
        List<Programtypeinfo> show = programtypeinfoService.show();
        model.addAttribute("list",show);
        PageInfo<List<Map<String, Object>>> listPageInfo = programinfoService.queryAll(page, size,ptid);
        model.addAttribute("programinfos",listPageInfo);
        model.addAttribute("ptid",ptid);
        return "programtypedetails.html";
    }
    //详情
    @RequestMapping("/xianqing")
    public String xinqing(@RequestParam("anchortid") Integer anchortid, @RequestParam("pid") Integer pid, ModelMap modelMap) {
        //节目
        modelMap.addAttribute("programinfo", programinfoService.query(pid, null, null, null).get(0));
        //主播节目
        modelMap.addAttribute("pros", programinfoService.query(null, null, anchortid, 6));
        //章节
        modelMap.addAttribute("chapterinfos", chapterinfoService.queryChapter(pid));
        return "xianqing.html";
    }
    //内容
    @RequestMapping("/context")
    public String context(ModelMap modelMap) {
        //节目类型
        modelMap.addAttribute("programtype", programtypeinfoService.show());
        //小编推荐查询
        modelMap.addAttribute("tuijian", programinfoService.query(null, null, null, 4));
        //热门
        modelMap.addAttribute("remeng", programinfoService.query(null, null, null, 9));
        //分类
        modelMap.addAttribute("yousheng", programinfoService.query(null, 3, null, 6));
        //主播
        modelMap.addAttribute("anchors", anchorinfoService.query(0, 4));
        return "context.html";
    }
    //用户详情
    @RequestMapping("/gerenxianqing")
    public String gerenxianqing(ModelMap modelMap, @RequestParam("name") String name, @RequestParam("acid") Integer acid,HttpSession session) {
        modelMap.addAttribute("name", name);
        //如果是创建节目把类型传过期
        if (name.equals("createprogram")) {
            System.out.println("主播编号:"+acid);
            modelMap.addAttribute("programtype", programtypeinfoService.show());
            modelMap.addAttribute("program", programinfoService.query(null, null, acid, null));
        }else if(name.equalsIgnoreCase("showinformation")){
           if(acid!=null){
               modelMap.addAttribute("program", programinfoService.query(null, null, acid, null));
           }
        }
        return "personalxianqing.html";
    }

    //用户的购买记录
    @RequestMapping("recoadshow")
    public String recoadshow(ModelMap model,
                             @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue ="8") Integer size
            ,HttpSession session){
        Map<String,Object> user = (Map<String, Object>) session.getAttribute("user");
        Integer front_userid = (Integer) user.get("front_userid");
        PageInfo<List<Map<String, Object>>> listPageInfo = buyService.show(page,size,front_userid);
        model.addAttribute("list",listPageInfo);

        return "recoadshow.html";
    }
    //查询用户充值记录
    @RequestMapping("recoadshow02")
    public String recoadshow02(ModelMap model,
              @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue ="8") Integer size
            ,HttpSession session){
        Map<String,Object> user = (Map<String, Object>) session.getAttribute("user");
        Integer front_userid = (Integer) user.get("front_userid");
        PageInfo<List<Map<String, Object>>> listPageInfo = topupinfoService.queryByuserRecord(page, size, front_userid);
        model.addAttribute("list",listPageInfo);
        return "recoadshow02.html";
    }

    //搜索节目
    @RequestMapping("search")
    public String search(ModelMap model,String name){
        model.addAttribute("program",programinfoService.soquery(name,null,null));
        return "searchdetails.html";
    }
    //我的收藏
    @RequestMapping("collectprogram")
    public String collectprogram(ModelMap model,HttpSession session){
        Map<String,Object> user = (Map<String, Object>) session.getAttribute("user");
        Integer front_userid = (Integer) user.get("front_userid");
        model.addAttribute("program",programinfoService.soquery(null,null,front_userid));

        return "collectprogram.html";
    }
    //我的购买记录
    @RequestMapping("myprogram")
    public String myprogram(ModelMap model,HttpSession session){
        Map<String,Object> user = (Map<String, Object>) session.getAttribute("user");
        Integer front_userid = (Integer) user.get("front_userid");
        model.addAttribute("program",programinfoService.myprogram(front_userid));
        return "myprogram.html";
    }

}
