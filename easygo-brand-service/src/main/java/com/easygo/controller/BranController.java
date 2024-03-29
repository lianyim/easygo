package com.easygo.controller;

import com.easygo.pojo.Brand;
import com.easygo.service.BrandService;
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
 * @Date 2020/3/27 11:02
 * @Description
 */
@RestController
public class BranController {
    @Autowired
    BrandService brandService;

    @RequestMapping("/brand_page")
    public PageUtils getBrandByPage(@RequestParam(defaultValue = "1",required = false) Integer pageIndex,
                                    @RequestParam(defaultValue = "5",required = false) Integer pageSize){
        int totalCount = brandService.getTotalCount();
        Map<String,Object> map = new HashMap<>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Brand> brands = brandService.getPageBrands(map);
        // 封装一个通用的分页工具类
        PageUtils pageUtils = new PageUtils(pageIndex,pageSize,totalCount,brands);
        return pageUtils;

    }

    @RequestMapping("/brand_getBrands")
    public List<Brand> getBrands(){
        return brandService.getBrands();
    }

    @RequestMapping("/brand_addBrand")
    public int addBrand(@RequestBody Brand brand){
        return brandService.addBrand(brand);
    }

    @RequestMapping("/brand_updateBrand")
    public int updateBrand(@RequestBody Brand brand){
        return brandService.updateBrand(brand);
    }

    @RequestMapping("/brand_getBrandById")
    public Brand getBrandById(@RequestParam Integer id){
       return brandService.getBrandById(id);
    }

    @RequestMapping("/brand_deleteBrand")
    public int deleteBrand(@RequestParam Integer id){
        return brandService.deleteBrand(id);
    }

    @RequestMapping("/brand_deleteSome")
    public int deleteSome(@RequestParam String ids){
        return brandService.deleteSome(ids);
    }
}
