package com.easygo.mapper;

import com.easygo.pojo.TypeTemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/5 21:10
 * @Description
 */
@Mapper
public interface TypeTemplateMapper {

    public Integer getTotalCount(Map<String,Object> map);

    public List<TypeTemplate> getTypeTemplatePage(Map<String,Object> map);

    public Integer addTypeTemplate(TypeTemplate typeTemplate);

    public TypeTemplate getTypeTemplateById(Integer id);

    public Integer updateTypeTemplate(TypeTemplate typeTemplate);

    public List<TypeTemplate> getTypeTemplates();

}


