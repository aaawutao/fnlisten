package com.aaa.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import sun.misc.BASE64Encoder;
import sun.net.www.protocol.http.HttpURLConnection;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PersonalApprove {


    public static  JSONObject  Approve(String image){
        String host = "https://yixi.market.alicloudapi.com";
        String path = "/ocr/idcardocr";
        String method = "POST";
        String appcode = "370aa4fee0cd44f9bf1590516b0e8f5e";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();

        bodys.put("image", image);
        bodys.put("side", "front");
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            //获取response的body
            String data = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject= JSONObject.parseObject(data);

            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 本地图片转换Base64的方法
     *
     * @param imgPath
     * @return
     */
    public static String LocalImageToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        System.out.println("本地图片转换Base64:" + encoder.encode(Objects.requireNonNull(data)));
        String strLocalImageToBase64 = encoder.encode(Objects.requireNonNull(data));
        return strLocalImageToBase64;
    }


    /**
     * 网络图片转换Base64的方法
     *
     * @param netImagePath
     */
    public static String NetImageToBase64(String netImagePath) {
        final ByteArrayOutputStream data = new ByteArrayOutputStream();
        String    strNetImageToBase64 = null;
        try {
            URL url = new URL(netImagePath);
            final byte[] by = new byte[1024];
            // 创建链接
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();
            // 将内容读取内存中
            int len = -1;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
            // 对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            strNetImageToBase64 = encoder.encode(data.toByteArray());
            System.out.println("网络图片转换Base64:" + strNetImageToBase64);
            // 关闭流
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strNetImageToBase64;
    }

}
