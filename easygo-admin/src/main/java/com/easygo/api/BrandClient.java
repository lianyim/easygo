package com.easygo.api;

import com.easygo.pojo.Brand;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/27 14:33
 * @Description
 */
@FeignClient(value = "EASYGO-BRAND-SERVICE")
public interface BrandClient {

    @RequestMapping("/brand_getBrandById")
    public Brand getBrandById(@RequestParam Integer id);

    @RequestMapping("/brand_addBrand")
    public int addBrand(@RequestBody Brand brand);

    @RequestMapping("/brand_getBrands")
    public List<Brand> getBrands();

    @RequestMapping("/brand_updateBrand")
    public int updateBrand(@RequestBody Brand brand);

    @RequestMapping("/brand_deleteBrand")
    public int deleteBrand(@RequestParam Integer id);

    @RequestMapping("/brand_deleteSome")
    public int deleteSome(@RequestParam String ids);

    @RequestMapping("/brand_page")
    public PageUtils getBrandByPage(@RequestParam Integer pageIndex, @RequestParam Integer pageSize);

}
