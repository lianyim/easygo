package com.easygo.utils;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @Author Lym
 * @Date 2020/4/21 17:50
 * @Description
 */
public class SendMessage {

    //短信地址
    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

    public static Integer sendMsg(String phoneNumber){
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);

        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
        //验证码
        int mobile_code = (int)((Math.random()*9+1)*100000);
        //短信内容
        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");  //短信内容
        //把短信的配置信息，配置到配置文件中 后期优化
        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "C28557677"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
                new NameValuePair("password", "8f0ff2392de68b04f0c2ff1946ed2e0d"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", phoneNumber), // 发送人的手机号
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);
        try {
            client.executeMethod(method);

            String SubmitResult =method.getResponseBodyAsString();
            //System.out.println(SubmitResult);

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();

            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");

            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);

            if("2".equals(code)){
                System.out.println("短信提交成功");
            }
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally{
            method.releaseConnection();
        }
        return mobile_code;
    }
}
