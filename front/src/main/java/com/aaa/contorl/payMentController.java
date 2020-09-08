package com.aaa.contorl;


import com.aaa.conflg.AlipayConfig;
import com.aaa.entity.Topupinfo;
import com.aaa.service.TopupinfoService;
import com.aaa.service.TopupsetinfoService;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@Slf4j
@RequestMapping("/payment")
public class payMentController {
    @Resource
    TopupinfoService topupinfoService;

    @RequestMapping(value = "pay", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String goAlipay(HttpServletResponse response, HttpServletRequest request) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        Random random = new Random();
        DecimalFormat df = new DecimalFormat("00");
        String no = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + df.format(random.nextInt(100));
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = no;
        //付款金额，必填
        String total_amount = request.getParameter("WIDtotal_amount");
        //订单名称，必填
        String subject = "懒人充值";
        //前台用户编号
        String front_userid = request.getParameter("front_userid");
        //充值类型
        String tsid = request.getParameter("tsid");
        //添加
        Topupinfo topupinfo = new Topupinfo();
        //商品编号
        topupinfo.setTpid(out_trade_no);
        topupinfo.setFront_userid(Integer.parseInt(front_userid));
        topupinfo.setTsid(Integer.parseInt(tsid));
        topupinfo.setState(0);
        topupinfo.setTopupway("支付宝");
        topupinfo.setTopupdate(new Date());
        topupinfo.setTsr(Double.valueOf(total_amount));
        topupinfoService.add(topupinfo);

        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"timeout_express\":\"" + timeout_express + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        return result;
    }

    /**
     * @Description: 支付宝异步 通知页面
     */
    @RequestMapping(value = "alipayNotifyNotice")
    public String alipayNotifyNotice(HttpServletRequest request, HttpServletRequest response) throws Exception {

        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            /*valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");*/
            params.put(name, valueStr);
        }

        //调用SDK验证签名
        //boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        boolean signVerified = true;
        //验证成功
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //修改状态,设置支付宝交易号
            topupinfoService.editState(out_trade_no, trade_no);
            //判断支付类型
            topupinfoService.panduan(out_trade_no);


        } else {//验证失败

            System.out.println("失败");
        }
        return "redirect:/main";
    }


}
