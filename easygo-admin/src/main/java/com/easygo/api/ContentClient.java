package com.easygo.api;

import com.easygo.pojo.Content;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/30 19:51
 * @Description
 */
@FeignClient(value = "EASYGO-AD-SERVICE")
public interface ContentClient {

    @RequestMapping("/content_getContentByCategoryId")
    public List<Content> getContentByCategoryId(@RequestParam Integer categoryId);

    // 更新广告
    @RequestMapping("/content_update")
    public Integer updateContent(@RequestBody Content content);

    // 根据id查询对象
    @RequestMapping("/content_getContentById")
    public Content getContentById(@RequestParam Integer id);

    // 新增广告
    @RequestMapping("/content_add")
    public Integer addContent(@RequestBody Content content);

    @RequestMapping("/content_page")
    public PageUtils<Content> getContent_page(@RequestParam(defaultValue = "1",required = false) Integer pageIndex,
                                              @RequestParam(defaultValue = "5",required = false) Integer pageSize);

    //有效无效
    @RequestMapping("/content_updateStatus")
    public Integer updateStatus(@RequestParam Integer id,@RequestParam Integer status);

}
