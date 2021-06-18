package com.easygo.service;

import com.easygo.pojo.Specification;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/1 17:23
 * @Description
 */
public interface SpecificationService {

    public Integer totalCount(Map<String,Object> map);

    public List<Specification> getSpecificationPage(Map<String,Object> map);

    public Integer addSpecification(Specification specification);

    // 事务版本的级联新增
    public Integer addSpecificationTransaction(String spec_name,String[] option_name,Integer[] orders);

    public Specification getSpecificationById(Integer id);

    public Integer specification_update(Integer id, String spec_name, String[] option_name, Integer[] orders);

    public List<Specification> getSpecifications();

}
