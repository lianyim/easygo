package com.easygo.mapper;

import com.easygo.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Lym
 * @Date 2020/3/29 15:44
 * @Description
 */
@Mapper
public interface AdminMapper {
    public Admin adminLogin(Admin admin);
}
