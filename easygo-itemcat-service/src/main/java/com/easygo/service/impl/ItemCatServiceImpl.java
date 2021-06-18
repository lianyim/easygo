package com.easygo.service.impl;

import com.easygo.mapper.ItemCatMapper;
import com.easygo.pojo.ItemCat;
import com.easygo.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/7 10:07
 * @Description
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Resource
    ItemCatMapper itemCatMapper;

    @Override
    public Integer getTotalCount(Map<String, Object> map) {
        return itemCatMapper.getTotalCount(map);
    }

    @Override
    public List<ItemCat> getItemCatsByPage(Map<String, Object> map) {
        return itemCatMapper.getItemCatsByPage(map);
    }

    @Override
    public ItemCat getItemCatById(Integer id) {
        return itemCatMapper.getItemCatById(id);
    }

    @Override
    public List<ItemCat> getItemCats() {
        return itemCatMapper.getItemCats();
    }

    @Override
    public Integer addItemCat(ItemCat itemCat) {
        return itemCatMapper.addItemCat(itemCat);
    }

    @Override
    public Integer updateItemCat(ItemCat itemCat) {
        return itemCatMapper.updateItemCat(itemCat);
    }
}
