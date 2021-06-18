package com.easygo.api;

import com.easygo.pojo.ContentCategory;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/30 10:52
 * @Description
 */
@FeignClient(value = "EASYGO-AD-SERVICE")
public interface ContentCategoryClient {

    // 查询所有广告(下拉框使用)
    @RequestMapping("/contentCategory_list")
    public List<ContentCategory> getContentCategorys();

    @RequestMapping("/contentCategory_delete")
    public int deleteContentCategory(Integer id);

    @RequestMapping("/contentCategory_update")
    public int updateContentCategory(@RequestBody ContentCategory category);

    @RequestMapping("/contentCategory_getById")
    public ContentCategory getById(@RequestParam Integer id);

    @RequestMapping("/contentCategory_add")
    public int addContentCategory(@RequestBody ContentCategory category);

    @RequestMapping("/contentCategory_page")
    public PageUtils<ContentCategory> getContentCategory(@RequestParam(defaultValue = "1",required = false) Integer pageIndex,
                                                         @RequestParam(defaultValue = "5",required = false) Integer pageSize,
                                                         @RequestParam(defaultValue = "",required = false) String name);

}
