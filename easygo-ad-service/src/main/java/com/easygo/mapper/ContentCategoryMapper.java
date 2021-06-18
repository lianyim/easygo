package com.easygo.mapper;

import com.easygo.pojo.ContentCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/3/30 9:59
 * @Description
 */
@Mapper
public interface ContentCategoryMapper {

    public Integer getTotalCount(Map<String,Object> map);

    public List<ContentCategory> getContentCategoryPages(Map<String,Object> map);

    public int addContentCategory(ContentCategory category);

    public int updateContentCategory(ContentCategory category);

    public  int deleteContentCategory(Integer id);

    public ContentCategory getById(Integer id);

    // 查询所有广告(下拉框使用)
    public List<ContentCategory> getContentCategorys();

}
