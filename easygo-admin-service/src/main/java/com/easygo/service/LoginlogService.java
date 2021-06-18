package com.easygo.service;

import com.easygo.pojo.Loginlog;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/29 21:07
 * @Description
 */
public interface LoginlogService {
    // 新增登录日志
    public int addLoginlog(Loginlog log);

    // 获取登录人的日志  最近10次登录日志
    public List<Loginlog> getMyLoginlogs(String username);
}
