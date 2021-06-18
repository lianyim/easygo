package com.easygo.client;

import com.easygo.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/17 19:51
 * @Description
 */
@FeignClient(value = "EASYGO-goods-SERVICE")
public interface GoodsClient {

    //查询上架的所有商品数据
    @RequestMapping("/goods_getGoods")
    public List<Goods> getGoods(@RequestParam Integer is_marketable);

}
