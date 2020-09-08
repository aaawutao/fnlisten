package com.aaa.util;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;


public class AddSmsSign {

    public static Integer setCode() {
        int i = (int) ((Math.random() * 9 + 1) * 100000);
        return i;
    }

    /**
     * <accessKeyId> 你自己的 accessKeyId      相当于账号
     * accessSecret  在创建用户时的 accessSecret 相当于密码
     */
    public static Map<String, Object> contextLoads(String phone) {

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GGeC4wRX8ZqFQL6gxtF", "iduG0BwLfs8tbP5HNutdDxnkjSvzNJ");
        IAcsClient client = new DefaultAcsClient(profile);
        //构建请求
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");//不能改 改了就会报错
        request.setSysVersion("2017-05-25");//不能改  改了就会报错
        request.setSysAction("SendSms");//一般也不会该改
        //自定义的参数(手机号，验证码，模板，签名)
        //参数名称不要乱写
        //手机号
        request.putQueryParameter("PhoneNumbers", phone);
        //签名名称
        request.putQueryParameter("SignName", "ABC听书");
        //模板code
        request.putQueryParameter("TemplateCode", "SMS_200185114");
        //使用随机数构建一个短信验证码
        Integer code = setCode();
        JsonObject param = new JsonObject();
        param.addProperty("code", code);
        //将定义好的验证码放入进去
        //短信验证码
        request.putQueryParameter("TemplateParam", String.valueOf(param));
        try {
            CommonResponse response = client.getCommonResponse(request);
            //控制台打印返回的信息
            String data = response.getData();
            JSONObject jsonObject = JSONObject.parseObject(data);
            jsonObject.put("codeResult", code);
            return jsonObject;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}

