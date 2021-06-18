package com.easygo.service;

import com.easygo.pojo.TypeTemplate;

import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/5 21:15
 * @Description
 */
public interface TypeTemplateService {

    public Integer getTotalCount(Map<String,Object> map);

    public List<TypeTemplate> getTypeTemplatePage(Map<String,Object> map);

    public Integer addTypeTemplate(TypeTemplate typeTemplate);

    public TypeTemplate getTypeTemplateById(Integer id);

    public Integer updateTypeTemplate(TypeTemplate typeTemplate);

    public List<TypeTemplate> getTypeTemplates();

}
