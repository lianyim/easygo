package com.easygo.api;

import com.easygo.pojo.ItemCat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/9 10:47
 * @Description
 */
@FeignClient(value = "easygo-itemcat-service")
public interface ItemCatClient {

    @RequestMapping("/itemcat_all")
    public List<ItemCat> getItemCats();

}
