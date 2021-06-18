package com.easygo.service.impl;

import com.easygo.mapper.ContentMapper;
import com.easygo.pojo.Content;
import com.easygo.pojo.ContentCategory;
import com.easygo.service.ContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/3/30 19:13
 * @Description
 */
@Service
public class ContentServiceImpl implements ContentService
{

    @Resource
    ContentMapper contentMapper;

    @Override
    public Integer getTotalCount() {
        return contentMapper.getTotalCount();
    }

    @Override
    public List<Content> getContents(Map<String, Object> map) {
        return contentMapper.getContents(map);
    }

    @Override
    public List<Content> getContentByCategoryId(Integer categoryId) {
        return contentMapper.getContentByCategoryId(categoryId);
    }

    @Override
    public Integer updateStatus(Map<String, Object> map) {
        return contentMapper.updateStatus(map);
    }

    @Override
    public Integer addContent(Content content) {
        return contentMapper.addContent(content);
    }

    @Override
    public Content getContentById(Integer id) {
        return contentMapper.getContentById(id);
    }

    @Override
    public Integer updateContent(Content content) {
        return contentMapper.updateContent(content);
    }


}
