package com.easygo.controller;

import com.easygo.pojo.GoodsDesc;
import com.easygo.service.GoodsDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lym
 * @Date 2020/4/20 10:49
 * @Description
 */
@RestController
@Scope("prototype")
public class GoodsDescController {

    @Autowired
    GoodsDescService goodsDescService;

    @RequestMapping("/goodsDesc_getById")
    public GoodsDesc getGoodsDescById(@RequestParam("id") Long id){
        return goodsDescService.getGoodsDescById(id);
    }

}
