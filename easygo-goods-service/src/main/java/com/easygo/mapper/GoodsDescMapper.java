package com.easygo.mapper;

import com.easygo.pojo.GoodsDesc;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Lym
 * @Date 2020/4/20 10:45
 * @Description
 */
@Mapper
public interface GoodsDescMapper {
    public GoodsDesc getGoodsDescById(Long id);
}
