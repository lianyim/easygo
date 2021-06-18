package com.easygo.controller;

import com.easygo.api.GoodsSearchClient;
import com.easygo.pojo.Goods;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Lym
 * @Date 2020/4/18 21:15
 * @Description
 */
@Controller
@Scope("prototype")
public class GoodsSearchController {

    @Autowired
    GoodsSearchClient goodsSearchClient;

    /**
     * 01-搜索的接口
     * @param pageIndex
     * @param pageSize
     * @param keyWords
     * @return
     */
    @RequestMapping("/goods_search")
    public String goods_search(
            @RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize",defaultValue = "12") Integer pageSize,
            @RequestParam(value = "keyWords",defaultValue = "") String keyWords, Model model
            ){
        PageUtils<Goods> pageUtils = goodsSearchClient.goods_search(pageIndex, pageSize, keyWords);
        model.addAttribute("pageUtils",pageUtils);
        System.out.println("搜索结果："+pageUtils);
        //回显搜索条件
        model.addAttribute("keyWords",keyWords);
        //跳至搜索列表页面
        return "categoryList";
    }

}
