package com.easygo.service.impl;

import com.easygo.mapper.ContentCategoryMapper;
import com.easygo.pojo.ContentCategory;
import com.easygo.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/3/30 10:24
 * @Description
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Resource
    ContentCategoryMapper categoryMapper;

    @Override
    public Integer getTotalCount(Map<String, Object> map) {
        return categoryMapper.getTotalCount(map);
    }

    @Override
    public List<ContentCategory> getContentCategoryPages(Map<String, Object> map) {
        return categoryMapper.getContentCategoryPages(map);
    }

    @Override
    public int addContentCategory(ContentCategory category) {
        return categoryMapper.addContentCategory(category);
    }

    @Override
    public int updateContentCategory(ContentCategory category) {
        return categoryMapper.updateContentCategory(category);
    }

    @Override
    public int deleteContentCategory(Integer id) {
        return categoryMapper.deleteContentCategory(id);
    }

    @Override
    public ContentCategory getById(Integer id) {
        return categoryMapper.getById(id);
    }

    @Override
    public List<ContentCategory> getContentCategorys() {
        return categoryMapper.getContentCategorys();
    }
}
