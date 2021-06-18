package com.easygo.test;

import java.io.IOException;

import com.easygo.utils.SendMessage;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author Lym
 * @Date 2020/4/21 17:34
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSendMessage {

    /**
     * 测试短信接口
     */
    @Test
    public void test(){
        String phone="17634726325"; //这是我的小号
        SendMessage.sendMsg(phone);
    }

}
