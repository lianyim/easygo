package com.easygo.mapper;

import com.easygo.pojo.ItemCat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/7 9:56
 * @Description
 */
@Mapper
public interface ItemCatMapper {

    // parent_id==0 表示一级分类
    public Integer getTotalCount(Map<String,Object> map);

    public List<ItemCat> getItemCatsByPage(Map<String,Object> map);

    public ItemCat getItemCatById(Integer id);

    //查询有效分类
    public List<ItemCat> getItemCats();

    public Integer addItemCat(ItemCat itemCat);

    public Integer updateItemCat(ItemCat itemCat);

}
