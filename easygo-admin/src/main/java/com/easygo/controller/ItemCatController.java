package com.easygo.controller;

import com.easygo.api.ItemCatClient;
import com.easygo.pojo.ItemCat;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/7 10:16
 * @Description
 */
@Controller
@Scope("prototype")
public class ItemCatController {

    @Autowired
    ItemCatClient itemCatClient;

    //跳转更新页面
    @RequestMapping("/typeTemplate_goupdate")
    @ResponseBody
    public ItemCat typeTemplate_goupdate(Integer id){
        //回显的对象
        return itemCatClient.getItemCatById(id);
    }

    @RequestMapping("/updateItemCat")
    @ResponseBody
    public MessageResults updateItemCat(ItemCat itemCat){
        MessageResults results = null;
        Integer i = itemCatClient.updateItemCat(itemCat);
        if (i>0){
            results=new MessageResults(200,"更新成功");
        }else {
            results=new MessageResults(500,"更新失败");
        }
        return results;
    }

    @RequestMapping("/addItemCat")
    @ResponseBody
    public MessageResults itemcat_add(ItemCat itemCat){
        MessageResults results = null;
        Integer i = itemCatClient.addItemCat(itemCat);
        if (i>0){
            results=new MessageResults(200,"新增成功");
        }else {
            results=new MessageResults(500,"新增失败");
        }
        return results;
    }

    @RequestMapping("/itemcat_page")
    public String itemcat_page(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                               @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                               @RequestParam(value = "parent_id",defaultValue = "0") Integer parent_id, Model model){

        PageUtils<ItemCat> pageUtils = itemCatClient.itemcat_page(pageIndex, pageSize, parent_id);
        boolean flag=false; //是否是三级类目
        //动态生成页面的导航条
        String str = "<li><a href=\"javascript:queryChilds(0);\" >顶级分类列表</a></li>";
        if (parent_id!=0){
            //表示子分类
            ItemCat itemCat1 = itemCatClient.getItemCatById(parent_id); //一级分类
            if (itemCat1!=null){
                //表示有二级分类
                String name1=itemCat1.getName();
                String str1="<li><a href=\"javascript:queryChilds(\"+itemCat1.getId()+\");\" >"+name1+"</a></li>";
                Integer parent_id1 = itemCat1.getParent_id();
                ItemCat itemCat2 = itemCatClient.getItemCatById(parent_id1); //二级分类
                if (itemCat2!=null){
                    String name2 = itemCat2.getName();
                    str=str+"<li><a href=\"javascript:queryChilds("+itemCat2.getId()+");\" >"+name2+"</a></li>";
                    flag=true; //表示已经是三级类目
                }
                str=str+str1;
            }
        }
        System.out.println(str);
        model.addAttribute("str",str); //导航菜单条
        model.addAttribute("flag",flag); //是否是三级类目
        model.addAttribute("pageUtils",pageUtils);
        //回显
        model.addAttribute("parent_id",parent_id);
        return "item_cat";
    }

}
