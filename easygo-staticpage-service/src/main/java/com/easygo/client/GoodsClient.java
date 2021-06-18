package com.easygo.client;

import com.easygo.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Lym
 * @Date 2020/4/20 9:54
 * @Description
 */
@FeignClient(value = "easygo-goods-service")
public interface GoodsClient {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/goods_getGoodsById")
    public Goods getGoodsById(@RequestParam("id") Long id);
}
