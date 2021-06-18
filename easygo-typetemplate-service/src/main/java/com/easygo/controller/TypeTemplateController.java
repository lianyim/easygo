package com.easygo.controller;

import com.easygo.pojo.Specification;
import com.easygo.pojo.TypeTemplate;
import com.easygo.service.TypeTemplateService;
import com.easygo.utils.JsonUtils;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/5 21:17
 * @Description
 */
@Controller
@Scope("prototype")
public class TypeTemplateController {

    @Autowired
    TypeTemplateService typeTemplateService;

    /**
     * 异步加载所有模板
     * @return
     */
    @RequestMapping("/typeTemplate_all")
    @ResponseBody
    public List<TypeTemplate> getTypeTemplates(){
        return typeTemplateService.getTypeTemplates();
    }

    /**
     * 更新
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/typeTemplate_update")
    @ResponseBody
    public Integer updateTypeTemplate(@RequestBody TypeTemplate typeTemplate){
       return typeTemplateService.updateTypeTemplate(typeTemplate);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/typeTemplate_getById")
    @ResponseBody
    public TypeTemplate getTypeTemplateById(@RequestParam Integer id){
        return typeTemplateService.getTypeTemplateById(id);
    }

    /**
     * 新增模板
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/typeTemplate_add")
    @ResponseBody
    public Integer addTypeTemplate(@RequestBody TypeTemplate typeTemplate){
        return typeTemplateService.addTypeTemplate(typeTemplate);
    }

    @RequestMapping("/typeTemplate_page")
    @ResponseBody
    public PageUtils<TypeTemplate> getTypeTemplatePage(
            @RequestParam(defaultValue = "1",required = false) Integer pageIndex,
            @RequestParam(defaultValue = "5",required = false) Integer pageSize,
            @RequestParam(defaultValue = "",required = false) String name){

        Map<String, Object> map = new HashMap<>(0);
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("name","%"+name+"%");
        Integer totalCount = typeTemplateService.getTotalCount(map);
        List<TypeTemplate> typeTemplates = typeTemplateService.getTypeTemplatePage(map);
        for (TypeTemplate typeTemplate : typeTemplates) {
            String brand_ids= JsonUtils.parseJson(typeTemplate.getBrand_ids());  // 格式化json
            typeTemplate.setBrand_ids(brand_ids);

            String spec_ids = JsonUtils.parseJson(typeTemplate.getSpec_ids());  // 格式化json
            typeTemplate.setSpec_ids(spec_ids);

            String custom_attribute_items = JsonUtils.parseJson(typeTemplate.getCustom_attribute_items());
            typeTemplate.setCustom_attribute_items(custom_attribute_items);

        }
        PageUtils<TypeTemplate> pageUtils = new PageUtils<TypeTemplate>(pageIndex, pageSize, totalCount, typeTemplates);
        return pageUtils;

    }

}
