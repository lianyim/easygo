package com.easygo.api;

import com.easygo.pojo.Content;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/30 21:52
 * @Description
 */
@FeignClient(value = "EASYGO-AD-SERVICE")
public interface ContentClient {

    @RequestMapping("/content_getContentByCategoryId")
    public List<Content> getContentByCategoryId(@RequestParam Integer categoryId);

}
