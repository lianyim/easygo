package com.easygo.service.impl;

import com.easygo.mapper.GoodsMapper;
import com.easygo.pojo.Goods;
import com.easygo.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/17 11:41
 * @Description
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoods(Integer is_marketable) {
        return goodsMapper.getGoods(is_marketable);
    }

    @Override
    public Goods getGoodsById(Long id) {
        return goodsMapper.getGoodsById(id);
    }
}
