package com.easygo.client;

import com.easygo.pojo.ItemCat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Lym
 * @Date 2020/4/20 15:00
 * @Description
 */
@FeignClient(value = "easygo-itemcat-service")
public interface ItemCatClient {
    /**
     * 根据id查询分类对象
     * @param id
     * @return
     */
    @RequestMapping("/itemcat_getById")
    public ItemCat getItemCatById(@RequestParam Integer id);
}
