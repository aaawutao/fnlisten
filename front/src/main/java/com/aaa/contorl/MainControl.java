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
            modelMap.addAttribute("programtype", programtypeinfoService.show());
            if (acid != 0) {
                modelMap.addAttribute("program", programinfoService.query(null, null, acid, null));
            }
        }
        if (name.equals("showinformation") && acid != 0) {
            //当前主播的节目
            modelMap.addAttribute("program", programinfoService.query(null, null, acid, null));
        }
        System.out.println(session.getAttribute("user"));
        //充值查询,用户id做查询
        if(name.equals("recoadshow02")){

        }
        if(name.equals("recoadshow")){

        }
        return "personalxianqing.html";
    }
    //充值记录
   /* @RequestMapping("/recoadshow")
    public String record(){
        return "recoadshow.html";
    }
   @RequestMapping("/recoadshow02")
    public String record2(){
        return "recoadshow02.html";
    }


    //账号详情
    @RequestMapping("/userdetails")
    public String userdatails(HttpSession session) {
        return "userdetails.html";
    }

    //认证详情
    @RequestMapping("/userrenzheng")
    public String renzheng() {
        return "userrenzheng.html";
    }

    //节目详情
    @RequestMapping("/showinformation")
    public String showinformation() {
        return "personalxianqing.html";
    }

    //创建节目
    @RequestMapping("/createprogram")
    public String createprogram() {
        return "createprogram.html";
    }
*/

}
