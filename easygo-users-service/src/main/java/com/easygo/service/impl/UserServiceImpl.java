package com.easygo.service.impl;

import com.easygo.mapper.UsersMapper;
import com.easygo.pojo.Users;
import com.easygo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Lym
 * @Date 2020/4/21 15:08
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UsersMapper usersMapper;

    @Override
    public Integer registerUsers(Users users) {
        return usersMapper.registerUsers(users);
    }
}
