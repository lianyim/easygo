package com.easygo.test;

import com.easygo.mapper.BrandMapper;
import com.easygo.pojo.Brand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/3/27 10:23
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBrand {

    @Resource
    BrandMapper brandMapper;

    @Test
    public void testBrands(){
        System.out.println(brandMapper);
        List<Brand> brands = brandMapper.getBrands();
        for (Brand brand : brands) {
            System.out.println(brand);
        }
    }

    @Test
    public void testGetById(){
        Brand brandById = brandMapper.getBrandById(1);
        System.out.println(brandById);
    }

    @Test
    public void testAdd(){
        Brand brand = new Brand();
        brand.setName("测试品牌");
        brand.setFirst_char("C");
        brand.setImage("151551315.jpg");
        int i = brandMapper.addBrand(brand);
        System.out.println(i>0?"新增成功":"新增失败");
    }

    @Test
    public void updateBrand(){
        Brand brand = new Brand();
        brand.setName("测试2500");
        brand.setFirst_char("Ff");
        brand.setImage("456789.jpg");
        brand.setId(48);
        int i = brandMapper.updateBrand(brand);
        System.out.println(i>0?"更新成功":"更新失败");
    }

    @Test
    public void deleteBrand(){
        int i = brandMapper.deleteBrand(46);
        System.out.println(i>0?"删除成功":"删除失败");
    }

    @Test
    public void deleteBrand1(){
        Integer[] ids = {20,21,22};
        int i = brandMapper.deleteSome1(ids);
        System.out.println(i>0?"删除成功":"删除失败");
    }

    @Test
    public void testGetTotalCount(){
        int totalCount = brandMapper.getTotalCount();
        System.out.println("查询的总数是："+totalCount);
    }

    @Test
    public void testPage(){
        int pageIndex=1;  // 当前页码
        int pageSize=5;  // 每页大小
        Map<String,Object> map=new HashMap<>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Brand> brands = brandMapper.getPageBrands(map);
        for (Brand brand : brands) {
            System.out.println(brand);
        }
    }

}
