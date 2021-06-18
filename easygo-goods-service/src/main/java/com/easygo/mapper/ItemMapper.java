package com.easygo.mapper;

import com.easygo.pojo.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/20 16:42
 * @Description
 */
@Mapper
public interface ItemMapper {

    //查询商品的所有SKU对象
    public List<Item> getItemsByGoodsId(Long goodsId);

}
