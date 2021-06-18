package com.easygo.controller;

import com.easygo.pojo.ContentCategory;
import com.easygo.service.ContentCategoryService;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/3/30 10:26
 * @Description
 */
@RestController
@Scope("prototype")
public class ContentCategoryController {

    @Autowired
    ContentCategoryService contentCategoryService;

    // 查询所有广告(下拉框使用)
    @RequestMapping("/contentCategory_list")
    public List<ContentCategory> getContentCategorys(){
        return contentCategoryService.getContentCategorys();
    }

    @RequestMapping("/contentCategory_delete")
    public int deleteContentCategory(Integer id){
        return contentCategoryService.deleteContentCategory(id);
    }

    @RequestMapping("/contentCategory_update")
    public int updateContentCategory(@RequestBody ContentCategory category){
        return contentCategoryService.updateContentCategory(category);
    }

    @RequestMapping("/contentCategory_getById")
    public ContentCategory getById(@RequestParam Integer id){
        return contentCategoryService.getById(id);
    }

    @RequestMapping("/contentCategory_add")
    public int addContentCategory(@RequestBody ContentCategory category){
       return contentCategoryService.addContentCategory(category);
    }

    @RequestMapping("/contentCategory_page")
    public PageUtils<ContentCategory> getContentCategory(@RequestParam(defaultValue = "1",required = false) Integer pageIndex,
                                                    @RequestParam(defaultValue = "5",required = false) Integer pageSize,
                                                    @RequestParam(defaultValue = "",required = false) String name){
        System.out.println("浏览器传来的数据pageIndex="+pageIndex+" pageSize="+pageSize+" name="+name);
        Map<String,Object> map=new HashMap<>();
        map.put("name","%"+name+"%");
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        Integer totalCount = contentCategoryService.getTotalCount(map);
        System.out.println("总条数是："+totalCount);
        List<ContentCategory> contentCategoryPages = contentCategoryService.getContentCategoryPages(map);
        System.out.println("查到的数据是："+contentCategoryPages);
        PageUtils<ContentCategory> pageUtils = new PageUtils<>(pageIndex,pageSize,totalCount,contentCategoryPages);
        return pageUtils;
    }

}
