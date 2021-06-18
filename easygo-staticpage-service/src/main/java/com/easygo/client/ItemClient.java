package com.easygo.client;

import com.easygo.pojo.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/20 16:50
 * @Description
 */
@FeignClient(value = "easygo-goods-service")
public interface ItemClient {

    //查询商品的所有SKU对象
    @RequestMapping("/item_getItemsByGoodsId")
    public List<Item> getItemsByGoodsId(@RequestParam("goodsId") Long goodsId);

}
