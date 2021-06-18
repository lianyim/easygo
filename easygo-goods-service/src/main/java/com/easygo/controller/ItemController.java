package com.easygo.controller;

import com.easygo.pojo.Item;
import com.easygo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/20 16:47
 * @Description
 */
@RestController
@Scope("prototype")
public class ItemController {

    @Autowired
    ItemService itemService;

    //查询商品的所有SKU对象
    @RequestMapping("/item_getItemsByGoodsId")
    public List<Item> getItemsByGoodsId(@RequestParam("goodsId") Long goodsId){
        return itemService.getItemsByGoodsId(goodsId);
    }
}
