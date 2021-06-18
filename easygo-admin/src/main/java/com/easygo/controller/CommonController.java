package com.easygo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lym
 * @Date 2020/3/29 16:08
 * @Description
 */
@Controller
@Scope("prototype")
public class CommonController {

    // 跳转登录页面
    @RequestMapping({"/","/admin"})
    public String toLogin(){
        return "login";
    }

    // 通用的页面跳转
    @RequestMapping("/page_{page}")
    public String page(@PathVariable("page") String page){
        return page;
    }

}
