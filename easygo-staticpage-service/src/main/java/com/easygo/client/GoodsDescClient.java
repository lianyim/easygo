package com.easygo.client;

import com.easygo.pojo.GoodsDesc;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Lym
 * @Date 2020/4/20 10:51
 * @Description
 */
@FeignClient(value = "easygo-goods-service")
public interface GoodsDescClient {

    @RequestMapping("/goodsDesc_getById")
    public GoodsDesc getGoodsDescById(@RequestParam("id") Long id);

}
