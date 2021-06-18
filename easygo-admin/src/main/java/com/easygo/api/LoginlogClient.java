package com.easygo.api;

import com.easygo.pojo.Loginlog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/29 22:13
 * @Description
 */
@FeignClient(value = "EASYGO-ADMIN-SERVICE")
public interface LoginlogClient {

    // 新增登录日志
    @RequestMapping("/addLoginlog")
    public int addLoginlog(@RequestBody Loginlog log);

    // 获取登录人的日志  最近10次登录日志
    @RequestMapping("/getLoginlogs")
    public List<Loginlog> getMyLoginlogs(@RequestParam String username);

}
