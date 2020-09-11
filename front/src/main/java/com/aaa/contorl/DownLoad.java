package com.aaa.contorl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class DownLoad {
    //静态路径
    @Value("${prop.filepath}")
    String staticurl;


    @RequestMapping("download")
    public void download(String url,HttpServletRequest request, HttpServletResponse response) throws IOException {
        //本地的磁盘 路径和文件路径做替换
       url=url.replace("http://localhost:9999/fileclient/staticfile/",staticurl);
        File file=new File(url);
        //设置文件输出流
        FileInputStream fs=new FileInputStream(file);
        String mimeType=request.getSession().getServletContext().getMimeType(url.substring(url.lastIndexOf(".")));
        response.setContentType(mimeType);
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode("音频文件"+file.getName(),"UTF-8"));
        ServletOutputStream outputStream=response.getOutputStream();
        FileCopyUtils.copy(fs,outputStream);
    }
}
