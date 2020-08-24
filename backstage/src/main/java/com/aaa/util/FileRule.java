package com.aaa.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class FileRule {
    String[] photoformat={"bmp","jpg","png","tif","gif","pcx","tga","exif","fpx","svg","psd","cdr","pcd","dxf","ufo","eps","ai","raw","WMF","webp"};
    //返回提交的路径
    public String fileupload(MultipartFile file,String username,String staticurl) throws IOException {
        //username :用户名
        //staticurl:配置的本地磁盘
        String uploadstr="";
        //获取文件名称
        String filename=file.getOriginalFilename();
        //判断文件名称是否存在
        if(!filename.isEmpty()){
            //判断用户名子文件是否存在
            File fileusername=new File(staticurl+"//"+username);
            if(!fileusername.exists()){
                //创建目录
                fileusername.mkdirs();
            }
            String filesuf=filename.substring(filename.lastIndexOf("."));
            //判断是否是图片
            if(Arrays.asList(photoformat).contains(filesuf)){
                File filephoto=new File(staticurl+"//"+username+"//photo");
                //判断filephoto文件加是否存在
                if(!filephoto.exists()){
                    //创建目录
                    filephoto.mkdirs();
                }
                //设置上传文件的名称
                String photo=new Date().getTime()+filesuf;
                uploadstr=staticurl+"//"+username+"//photo//"+photo;
                File newfile = new File(uploadstr);
                //文件做提交
                file.transferTo(newfile);
            }
            //判断是否是音频
            if(filesuf.equals("mp3")){
                File fileAudio=new File(staticurl+"//"+username+"//audio");
                //判断filephoto文件加是否存在
                if(!fileAudio.exists()){
                    //创建目录
                    fileAudio.mkdirs();
                }
                //上传文件
                //设置上传文件的名称
                String audio=new Date().getTime()+filesuf;
                uploadstr=staticurl+"//"+username+"//audio//"+audio;
                File newfile = new File(uploadstr);
                //文件做提交
                file.transferTo(newfile);
            }
        }
        return uploadstr;
    }
}
