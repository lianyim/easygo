package com.easygo.api;

import com.easygo.pojo.TypeTemplate;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/5 21:29
 * @Description
 */
@FeignClient(value = "easygo-typetemplate-service")
public interface TypeTemplateClient {

    /**
     * 异步加载所有模板
     * @return
     */
    @RequestMapping("/typeTemplate_all")
    public List<TypeTemplate> getTypeTemplates();

    /**
     * 更新
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/typeTemplate_update")
    public Integer updateTypeTemplate(@RequestBody TypeTemplate typeTemplate);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/typeTemplate_getById")
    public TypeTemplate getTypeTemplateById(@RequestParam Integer id);

    /**
     * 新增模板
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/typeTemplate_add")
    public Integer addTypeTemplate(@RequestBody TypeTemplate typeTemplate);

    @RequestMapping("/typeTemplate_page")
    public PageUtils<TypeTemplate> getTypeTemplatePage(
            @RequestParam(defaultValue = "1",required = false) Integer pageIndex,
            @RequestParam(defaultValue = "5",required = false) Integer pageSize,
            @RequestParam(defaultValue = "",required = false) String name);

}
