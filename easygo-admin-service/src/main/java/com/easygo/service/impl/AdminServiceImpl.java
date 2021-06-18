package com.easygo.service.impl;

import com.easygo.mapper.AdminMapper;
import com.easygo.pojo.Admin;
import com.easygo.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Lym
 * @Date 2020/3/29 15:52
 * @Description
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminMapper adminMapper;

    @Override
    public Admin adminLogin(Admin admin) {
        return adminMapper.adminLogin(admin);
    }
}
