package com.easygo.service.impl;

import com.easygo.mapper.LoginlogMapper;
import com.easygo.pojo.Loginlog;
import com.easygo.service.LoginlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/29 21:08
 * @Description
 */
@Service
public class LoginlogServiceImpl implements LoginlogService {

    @Resource
    LoginlogMapper loginlogMapper;

    @Override
    public int addLoginlog(Loginlog log) {
        return loginlogMapper.addLoginlog(log);
    }

    @Override
    public List<Loginlog> getMyLoginlogs(String username) {
        return loginlogMapper.getMyLoginlogs(username);
    }
}
