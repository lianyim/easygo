package com.easygo.api;

import com.easygo.pojo.Admin;
import com.easygo.pojo.Loginlog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/29 16:01
 * @Description
 */
@FeignClient(value = "EASYGO-ADMIN-SERVICE")
public interface AdminClient {

    @RequestMapping("/admin_login")
    public Admin adminLogin(@RequestBody Admin admin);

}
