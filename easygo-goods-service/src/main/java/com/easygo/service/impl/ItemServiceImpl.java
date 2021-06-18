package com.easygo.service.impl;

import com.easygo.mapper.ItemMapper;
import com.easygo.pojo.Item;
import com.easygo.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/20 16:46
 * @Description
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    ItemMapper itemMapper;

    @Override
    public List<Item> getItemsByGoodsId(Long goodsId) {
        return itemMapper.getItemsByGoodsId(goodsId);
    }
}
