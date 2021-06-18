package com.easygo;

import com.easygo.utils.JsonUtils;
import org.junit.Test;

/**
 * @Author Lym
 * @Date 2020/4/6 10:13
 * @Description
 */

public class TestJson {

    @Test
    public void test1(){
        String s = JsonUtils.parseJson("[{\"id\":23,\"text\":\"美特斯邦威\"},{\"id\":24,\"text\":\"森马\"},{\"id\":32,\"text\":\"阿迪达斯\"},{\"id\":42,\"text\":\"花花公子\"}]");
        System.out.println(s);
    }

}
