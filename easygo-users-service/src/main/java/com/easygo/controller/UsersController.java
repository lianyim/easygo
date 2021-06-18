package com.easygo.controller;

import com.easygo.pojo.Users;
import com.easygo.service.UserService;
import com.easygo.utils.MessageResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lym
 * @Date 2020/4/21 15:09
 * @Description
 */
@RestController
@Scope("prototype")
public class UsersController {

    @Autowired
    UserService userService;

    /**
     * 用户注册
     * @param users
     * @return
     */
    @RequestMapping("/users_add")
    public Integer users_add(@RequestBody Users users){
        return userService.registerUsers(users);
    }

}
