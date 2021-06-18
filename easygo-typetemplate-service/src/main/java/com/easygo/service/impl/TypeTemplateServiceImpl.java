package com.easygo.service.impl;

import com.easygo.mapper.TypeTemplateMapper;
import com.easygo.pojo.TypeTemplate;
import com.easygo.service.TypeTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/5 21:16
 * @Description
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Resource
    TypeTemplateMapper typeTemplateMapper;

    @Override
    public Integer getTotalCount(Map<String, Object> map) {
        return typeTemplateMapper.getTotalCount(map);
    }

    @Override
    public List<TypeTemplate> getTypeTemplatePage(Map<String, Object> map) {
        return typeTemplateMapper.getTypeTemplatePage(map);
    }

    @Override
    public Integer addTypeTemplate(TypeTemplate typeTemplate) {
        return typeTemplateMapper.addTypeTemplate(typeTemplate);
    }

    @Override
    public TypeTemplate getTypeTemplateById(Integer id) {
        return typeTemplateMapper.getTypeTemplateById(id);
    }

    @Override
    public Integer updateTypeTemplate(TypeTemplate typeTemplate) {
        return typeTemplateMapper.updateTypeTemplate(typeTemplate);
    }

    @Override
    public List<TypeTemplate> getTypeTemplates() {
        return typeTemplateMapper.getTypeTemplates();
    }
}
