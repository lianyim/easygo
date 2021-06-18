package com.easygo.api;

import com.easygo.pojo.Goods;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Lym
 * @Date 2020/4/18 21:13
 * @Description
 */
@FeignClient(value = "easygo-search-service")
public interface GoodsSearchClient {

    /**
     * 01-搜索的接口
     * @param pageIndex
     * @param pageSize
     * @param keyWords
     * @return
     */
    @RequestMapping("/goods_search")
    public PageUtils<Goods> goods_search(
            @RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
            @RequestParam(value = "keyWords",defaultValue = "") String keyWords
    );

}
