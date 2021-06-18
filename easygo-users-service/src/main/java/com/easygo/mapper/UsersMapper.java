package com.easygo.mapper;

import com.easygo.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Lym
 * @Date 2020/4/21 15:00
 * @Description
 */
@Mapper
public interface UsersMapper {

    public Integer registerUsers(Users users);

}
