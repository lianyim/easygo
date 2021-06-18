package com.easygo.mapper;

import com.easygo.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/17 11:03
 * @Description
 */
@Mapper
public interface GoodsMapper {

    //查询所有上架的商品数据
    public List<Goods> getGoods(Integer is_marketable);

    //根据id查询
    public Goods getGoodsById(Long id);

}
