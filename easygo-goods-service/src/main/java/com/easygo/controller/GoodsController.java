package com.easygo.controller;

import com.easygo.pojo.Goods;
import com.easygo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/17 11:43
 * @Description
 */
@RestController
@Scope("prototype")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/goods_getGoodsById")
    public Goods getGoodsById(@RequestParam("id") Long id){
        return goodsService.getGoodsById(id);
    }

    //查询上架的所有商品数据
    @RequestMapping("/goods_getGoods")
    public List<Goods> getGoods(@RequestParam Integer is_marketable){
        return goodsService.getGoods(is_marketable);
    }

}
