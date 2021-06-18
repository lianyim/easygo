package com.easygo.service;

import com.easygo.pojo.Content;
import com.easygo.pojo.ContentCategory;

import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/3/30 19:12
 * @Description
 */
public interface ContentService {

    public Integer getTotalCount();

    public List<Content> getContents(Map<String,Object> map);

    // 查询指定类目下的所有有效广告
    public List<Content> getContentByCategoryId(Integer categoryId);

    //有效无效
    public Integer updateStatus(Map<String,Object> map);

    // 新增广告
    public Integer addContent(Content content);

    // 根据id查询对象
    public Content getContentById(Integer id);

    // 更新广告
    public Integer updateContent(Content content);


}
