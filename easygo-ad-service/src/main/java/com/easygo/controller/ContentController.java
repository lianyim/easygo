package com.easygo.controller;

import com.easygo.pojo.Content;
import com.easygo.pojo.ContentCategory;
import com.easygo.service.ContentService;
import com.easygo.utils.MessageResults;
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
 * @Date 2020/3/30 19:14
 * @Description
 */
@RestController
@Scope("prototype")
public class ContentController {

    @Autowired
    ContentService contentService;

    // 更新广告
    @RequestMapping("/content_update")
    public Integer updateContent(@RequestBody Content content){
        return contentService.updateContent(content);
    }

    // 根据id查询对象
    @RequestMapping("/content_getContentById")
    public Content getContentById(@RequestParam Integer id){
        return contentService.getContentById(id);
    }

    @RequestMapping("/content_page")
    public PageUtils<Content> getContent_page(@RequestParam(defaultValue = "1",required = false) Integer pageIndex,
                                 @RequestParam(defaultValue = "5",required = false) Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        Integer totalCount = contentService.getTotalCount();
        List<Content> contents = contentService.getContents(map);
        return new PageUtils<>(pageIndex,pageSize,totalCount,contents);
    }

    // 查询指定类目下的所有有效广告
    @RequestMapping("/content_getContentByCategoryId")
    public List<Content> getContentByCategoryId(@RequestParam Integer categoryId){
        return contentService.getContentByCategoryId(categoryId);
    }

    //有效无效
    @RequestMapping("/content_updateStatus")
    public Integer updateStatus(@RequestParam Integer id,@RequestParam Integer status){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("status",status);
        return contentService.updateStatus(map);
    }

    // 新增广告
    @RequestMapping("/content_add")
    public Integer addContent(@RequestBody Content content){
        return contentService.addContent(content);
    }

}
