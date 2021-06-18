package com.easygo.api;

import com.easygo.pojo.Specification;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/2 9:49
 * @Description
 */
@FeignClient(value = "easygo-specification-service")
public interface SpecificationClient {

    /**
     * 准备要回显的数据(...)
     * @param id
     * @return
     */
    @RequestMapping("/getSpecification_getById")
    public Specification getSpecificationById(@RequestParam Integer id);

    @RequestMapping("/specifications_all")
    public List<Specification> getSpecifications();

    @RequestMapping("/specification_update")
    public Integer specification_update(@RequestParam Integer id, @RequestParam String spec_name,@RequestParam String[] option_name,@RequestParam Integer[] orders);

    /**
     * 更新时的数据回显
     * @param id
     * @return
     */
    @RequestMapping("/specification_getById")
    public Map<String,Object> getSpecification(@RequestParam Integer id);

    @RequestMapping("/specification_add")
    public Integer specification_add(@RequestParam String spec_name, @RequestParam String[] option_name, @RequestParam Integer[] orders);

    /**
     * 规格服务的后台
     * @param pageIndex
     * @param pageSize
     * @param spec_name
     * @return
     */
    @RequestMapping("/specification_pages")
    public PageUtils<Specification> specification_pages(
            @RequestParam(defaultValue = "1",required = false) Integer pageIndex,
            @RequestParam(defaultValue = "5",required = false) Integer pageSize,
            @RequestParam(defaultValue = "",required = false) String spec_name);

}
