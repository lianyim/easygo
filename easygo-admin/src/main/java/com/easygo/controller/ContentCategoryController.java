package com.easygo.controller;

import com.easygo.api.ContentCategoryClient;
import com.easygo.pojo.ContentCategory;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/30 10:53
 * @Description
 */
@Controller
@Scope("prototype")
public class ContentCategoryController {

    @Autowired
    ContentCategoryClient contentCategoryClient;

    /**
     * 更新广告分类
     * @param category
     * @return
     */
    @RequestMapping("/contentCategory_update")
    @ResponseBody
    public MessageResults contentCategory_update(ContentCategory category){
        int i = contentCategoryClient.updateContentCategory(category);
        MessageResults results = null;
        if (i>0){
            results=new MessageResults(200,"更新成功");
        }else {
            results=new MessageResults(500,"更新失败");
        }
        return results;
    }

    @RequestMapping("/contentCategory_getById")
    @ResponseBody
    public ContentCategory contentCategory_getById(Integer id){
        return contentCategoryClient.getById(id);
    }

    /**
     * 新增广告分类
     * @param category
     * @return
     */
    @RequestMapping("/contentCategory_add")
    @ResponseBody
    public MessageResults contentCategory_add(ContentCategory category){
        System.out.println("新增的广告："+category);
        int i = contentCategoryClient.addContentCategory(category);
        MessageResults results = null;
        if (i>0){
            results=new MessageResults(200,"删除成功");
        }else {
            results=new MessageResults(500,"删除失败");
        }
        return results;
    }

    @RequestMapping("/contentCategory_page")
    public String getContentCategory(Model model, @RequestParam(defaultValue = "1",required = false) Integer pageIndex,
                                     @RequestParam(defaultValue = "5",required = false) Integer pageSize,
                                     @RequestParam(defaultValue = "",required = false) String name){
        PageUtils<ContentCategory> pageUtils = contentCategoryClient.getContentCategory(pageIndex, pageSize, name);
        model.addAttribute("pageUtils",pageUtils);
        // 回显搜索条件
        model.addAttribute("name",name);
        return "content_category";
    }

    // 查询所有广告(下拉框使用)
    @RequestMapping("/contentCategory_list")
    @ResponseBody
    public List<ContentCategory> getContentCategorys(){
        List<ContentCategory> contentCategorys = contentCategoryClient.getContentCategorys();
        return contentCategorys;
    }

}
