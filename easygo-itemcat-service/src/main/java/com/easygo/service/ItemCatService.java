package com.easygo.service;

import com.easygo.pojo.ItemCat;

import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/7 10:05
 * @Description
 */
public interface ItemCatService {

    public Integer getTotalCount(Map<String,Object> map);

    public List<ItemCat> getItemCatsByPage(Map<String,Object> map);

    public ItemCat getItemCatById(Integer id);

    //查询有效分类
    public List<ItemCat> getItemCats();

    public Integer addItemCat(ItemCat itemCat);

    public Integer updateItemCat(ItemCat itemCat);

}
