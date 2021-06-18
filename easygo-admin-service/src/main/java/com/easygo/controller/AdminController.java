package com.easygo.controller;

import com.easygo.pojo.Admin;
import com.easygo.pojo.Loginlog;
import com.easygo.service.AdminService;
import com.easygo.service.LoginlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/29 15:53
 * @Description
 */
@RestController
@Scope("prototype")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    LoginlogService loginlogService;

    // 新增登录日志
    @RequestMapping("/addLoginlog")
    public int addLoginlog(@RequestBody Loginlog log){
        System.out.println("新增的日志对象:"+log);
        return loginlogService.addLoginlog(log);
    }

    // 获取登录人的日志  最近10次登录日志
    @RequestMapping("/getLoginlogs")
    public List<Loginlog> getMyLoginlogs(@RequestParam String username){
        return loginlogService.getMyLoginlogs(username);
    }

    @RequestMapping("/admin_login")
    public Admin adminLogin(@RequestBody Admin admin){
        return adminService.adminLogin(admin);
    }
}
