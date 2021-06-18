package com.easygo.api;

import com.easygo.pojo.ItemCat;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Lym
 * @Date 2020/4/7 10:15
 * @Description
 */
@FeignClient(value = "easygo-itemcat-service")
public interface ItemCatClient {

    @RequestMapping("/updateItemCat")
    public Integer updateItemCat(@RequestBody ItemCat itemCat);

    /**
     * 根据id查询分类对象
     * @param id
     * @return
     */
    @RequestMapping("/itemcat_getById")
    public ItemCat getItemCatById(@RequestBody Integer id);

    @RequestMapping("/addItemCat")
    public Integer addItemCat(@RequestBody ItemCat itemCat);

    @RequestMapping("/itemcat_page")
    public PageUtils<ItemCat> itemcat_page(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                           @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                           @RequestParam(value = "parent_id",defaultValue = "0") Integer parent_id);

}
