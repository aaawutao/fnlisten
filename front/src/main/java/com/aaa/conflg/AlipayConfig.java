package com.aaa.conflg;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    public static String app_id = "2016101600699651";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCdsgUe1Ylnng8uR+8D2XP3Tsbn7Mlk/xv+OuDRPOmp/opC2FLyRSCGUVaXxAUsZRRmeLyT8K0s3MC13AYgpSMd0OsclY7YDaoqO6cHqsq+RRlC7J8EtrKwUD5JoPbumuruLZKhYD27GVb+vAn3pZuwZVUxtJwDPmIGhzEP6J3AcvUyobT6VXAI5I2ANULpmIWiAS07sWRtOxoYMYm9y2xGqyC55XJxb1DOHLZ8swybFN2zUBe1I34k5oRa1YGWQFhrHOPVhF7L3F5Y9sOXsrP9ZYSyWsTquWYmdeXEK1LcVweoyUWBdD1c4mbEObjdEhugTzWPL/cBPC0vEzonZeFZAgMBAAECggEANQ/FsU5g4cDJkuUZg84Tu0+Cll+SlK1SmgTtyPoaFd1UYJGxt1uTSh7saDzJENsiNijCK3V8j+/n2Emkti9a1ZmKwx9/5SsT6woPdgD+H2/YxDAigc+H6NPXYacL79Wo32PuRua/Xsl0AFr9b5sF/CDcvdDr/htrmI6874FyM2LwFnaP3MByxBb5LDS7FLWj1/h0qEP/bmVjdzqbHN1UVGNOxMGvUM8cJzdqT0rGIbmjrzdHwU8lKpBfbQRwsWfQ4bvF97fiOc+xeh4TDAB+193UGvOps1ooWsMq0kWuq9UQ1tQfo/DcduulRz0D/juo7q2U0ZzEdhrFoI6iITqLUQKBgQD+6E/wXiy+aZ7EWsHwcUhE/Z76Htzn5Oxs3D7QQ3+bxXKuHCXMlbod8274BLcRZEKw0EEmvsfeufEX/XawOnkdrKa2HyriR38truBcx/bGNeegA4dqtq3BEcxS+LMDHrVbTAtNNJy0Fz29Prkum2Hll9KTJ76banS8N130mg49VwKBgQCeXwufhA4jYiSdsSdEzRjBY73bP3akt80xPmKbfIUaLaP0xlQCVEXtc8g9t652rk1+AAvXjh9d7HMxyw2U+H4o2SeQ/2r4V2RZddpA/Rtp/ZThGSqBLJ4PXIEERFYT0jSibR9o5+5sn65FprkzVnL42aaGdYp0laCIAevBiXr4zwKBgQC+19sRkNBa9uShCXnttEJxNJjTlku5ahEAJ5z3e7GMRDVp2TULiIXBasIH+i+9W5z6l9BPW8J0JC420dMMeZq39s0RyR/oLbMv1p+vlx5Qo4b4q+u0n3RS+ipJbF1J1rHc2oATm3I++q+EgfNOy5JtvE8xUS5JWVhwmdtECBrlHQKBgHZdpzxD4KVFdwR9IVJkz/nKaF3zouMdlLkXXW/Es16Leh06FhPflJwSizjFjhmZ0MU5l6A10u/KB5bRoocS6ofxNYdDv1l5R8EtOkCUa+bd5mYO/xuok0H761mbEZKi6z/yuyUXI7X/6qqYH5dlJ20ijzmzpBXaty6v8NqnvEc1AoGAA6RIPY8l4mWKFThP3o81zFYsBfXkHHJZse8WtmDF9FjOE2Swlm2IyYqfE5vny2FlT6opVxDB9Xv5hTLE0BHwfgIo/eS5oyRDYraedzctN2UI4gZjLunw1pvEVexRob50LZfkmRiIsr2F3NHyuL/vepzFLqmmzQQSfJSt1RTlHms=";

    // RSA2(SHA256)密钥(推荐) 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoBkxh890rTjxJfeSe4pbfEOTUjC2N5/YCHbAXGE3xs1vq3v3+t+uI6Lxfcs/CXnYc/8tR4Z1hZb8FcLKVCQ7ukBILUPFO8gWkuiK7HZ1hj29lEXR4gUPhtoCbMARHHjYxOKj2H/8dtQSUEMI2HFVhrKMIYcFuDgN0XHH9EpKX6sP8QzGeLAuOPTUihC3rf4P1P0n15q1axvSzVmKmmYZztjP0nQ19tZH29BEv7O5dOI9k9Ck30wDG3vjh1ql4pfZmEUaS3mjuYN4c9wJnseQpIxDedPwnQ28DWFulowtQLa8HtE5IS5W0+xL0UE3bAE07f/+NtP7Zzz8/KeL1vab4wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8082/front/payment/alipayNotifyNotice";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8082/front/payment/alipayNotifyNotice";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

