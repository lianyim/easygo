package com.easygo.mapper;

import com.easygo.pojo.Loginlog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/29 20:52
 * @Description  登录日志操作的接口方法
 */
@Mapper
public interface LoginlogMapper {

    // 新增登录日志
    public int addLoginlog(Loginlog log);

    // 获取登录人的日志  最近10次登录日志
    public List<Loginlog> getMyLoginlogs(String username);

}
