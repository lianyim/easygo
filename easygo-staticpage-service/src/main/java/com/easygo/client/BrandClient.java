package com.easygo.client;

import com.easygo.pojo.Brand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Lym
 * @Date 2020/4/20 11:47
 * @Description
 */
@FeignClient(value = "easygo-brand-service")
public interface BrandClient {

    @RequestMapping("/brand_getBrandById")
    public Brand getBrandById(@RequestParam Integer id);

}
