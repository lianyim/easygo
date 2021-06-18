package com.easygo.controller;

import com.easygo.pojo.ItemCat;
import com.easygo.service.ItemCatService;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/7 10:07
 * @Description
 */
@RestController
public class ItemCatController {

    @Autowired
    ItemCatService itemCatService;

    @RequestMapping("/updateItemCat")
    public Integer updateItemCat(@RequestBody ItemCat itemCat){
        return itemCatService.updateItemCat(itemCat);
    }

    @RequestMapping("/addItemCat")
    public Integer addItemCat(@RequestBody ItemCat itemCat){
        return itemCatService.addItemCat(itemCat);
    }

    /**
     * 所有类目
     * @return
     */
    @RequestMapping("/itemcat_all")
    public List<ItemCat> getItemCats(){
        return itemCatService.getItemCats();
    }

    /**
     * 根据id查询分类对象
     * @param id
     * @return
     */
    @RequestMapping("/itemcat_getById")
    public ItemCat getItemCatById(@RequestParam Integer id){
        return itemCatService.getItemCatById(id);
    }

    @RequestMapping("/itemcat_page")
    public PageUtils<ItemCat> itemcat_page(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                           @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                           @RequestParam(value = "parent_id",defaultValue = "0") Integer parent_id){

        Map<String,Object> map=new HashMap<>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("parent_id",parent_id);

        Integer totalCount = itemCatService.getTotalCount(map);
        List<ItemCat> itemCats = itemCatService.getItemCatsByPage(map);
        return new PageUtils<>(pageIndex,pageSize,totalCount,itemCats);
    }

}
