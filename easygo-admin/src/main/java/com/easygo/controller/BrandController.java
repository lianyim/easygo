package com.easygo.controller;

import com.easygo.api.BrandClient;
import com.easygo.pojo.Brand;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/27 14:30
 * @Description
 */
@Controller
@Scope("prototype")
public class BrandController {

    @Autowired
    BrandClient brandClient;

    @RequestMapping("/brand_addBrand")
    @ResponseBody
    public MessageResults addBrand(Brand brand){
        int i = brandClient.addBrand(brand);
        MessageResults results;
        if (i>0){
            results = new MessageResults(200,"新增成功");
        }else {
            results = new MessageResults(500,"新增失败");
        }
        return results;
    }

    @RequestMapping("/brand_getBrandById")
    @ResponseBody
    public Brand getBrandById(Integer id){
        return brandClient.getBrandById(id);
    }

    @RequestMapping("/brand_getBrands")
    public String getBrands(Model model){
        List<Brand> brands = brandClient.getBrands();
        model.addAttribute("brands",brands);
        return "brand";
    }

    @RequestMapping("/brand_updateBrand")
    @ResponseBody
    public MessageResults brand_update(Brand brand){
        MessageResults results = null;
        int i = brandClient.updateBrand(brand);
        if (i>0){
            results=new MessageResults(200,"更新成功");
        }else {
            results=new MessageResults(500,"更新失败");
        }
        return results;
    }

    @RequestMapping("/brand_deleteBrand")
    @ResponseBody
    public MessageResults deleteBrand(Integer id){
        MessageResults results = null;
        int i = brandClient.deleteBrand(id);
        if (i>0){
            results=new MessageResults(200,"删除成功");
        }else {
            results=new MessageResults(500,"删除失败");
        }
        return results;
    }

    @RequestMapping("/brand_deleteSome")
    @ResponseBody
    public MessageResults deleteSome(String ids){
        MessageResults results = null;
        int i = brandClient.deleteSome(ids);
        if (i>0){
            results=new MessageResults(200,"删除成功");
        }else {
            results=new MessageResults(500,"删除失败");
        }
        return results;
    }

    @RequestMapping("/brand_page")
    public String getBrandByPage(@RequestParam Integer pageIndex, @RequestParam Integer pageSize,Model model){
        PageUtils pageUtils = brandClient.getBrandByPage(pageIndex, pageSize);
        model.addAttribute("pageUtils",pageUtils);
        return "brand";
    }

}
