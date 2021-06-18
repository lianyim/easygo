package com.easygo.api;

import com.easygo.pojo.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Lym
 * @Date 2020/4/21 15:28
 * @Description
 */
@FeignClient(value = "easygo-users-service")
public interface UsersClient {

    /**
     * 用户注册
     * @param users
     * @return
     */
    @RequestMapping("/users_add")
    public Integer users_add(@RequestBody Users users);

}
