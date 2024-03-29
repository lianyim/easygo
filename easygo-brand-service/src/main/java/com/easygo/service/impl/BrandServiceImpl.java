package com.easygo.service.impl;

import com.easygo.mapper.BrandMapper;
import com.easygo.pojo.Brand;
import com.easygo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/3/27 11:01
 * @Description
 */
@Service
public class BrandServiceImpl implements BrandService
{

    @Resource
    BrandMapper brandMapper;

    @Override
    public List<Brand> getBrands() {
        return brandMapper.getBrands();
    }

    @Override
    public int addBrand(Brand brand) {
        return brandMapper.addBrand(brand);
    }

    @Override
    public int updateBrand(Brand brand) {
        return brandMapper.updateBrand(brand);
    }

    @Override
    public Brand getBrandById(Integer id) {
        return brandMapper.getBrandById(id);
    }

    @Override
    public int deleteBrand(Integer id) {
        return brandMapper.deleteBrand(id);
    }

    @Override
    public int deleteSome(String ids) {
        return brandMapper.deleteSome(ids);
    }

    @Override
    public int getTotalCount() {
        return brandMapper.getTotalCount();
    }

    @Override
    public List<Brand> getPageBrands(Map<String, Object> map) {
        return brandMapper.getPageBrands(map);
    }
}
