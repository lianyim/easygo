package com.easygo.service;

import com.easygo.pojo.Item;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/20 16:45
 * @Description
 */
public interface ItemService {
    //查询商品的所有SKU对象
    public List<Item> getItemsByGoodsId(Long goodsId);
}
