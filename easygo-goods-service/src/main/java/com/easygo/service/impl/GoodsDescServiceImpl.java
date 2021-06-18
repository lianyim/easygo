package com.easygo.service.impl;

import com.easygo.mapper.GoodsDescMapper;
import com.easygo.pojo.GoodsDesc;
import com.easygo.service.GoodsDescService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Lym
 * @Date 2020/4/20 10:48
 * @Description
 */
@Service
public class GoodsDescServiceImpl implements GoodsDescService {

    @Resource
    GoodsDescMapper goodsDescMapper;

    @Override
    public GoodsDesc getGoodsDescById(Long id) {
        return goodsDescMapper.getGoodsDescById(id);
    }
}
