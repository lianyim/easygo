package com.easygo.mapper;

import com.easygo.pojo.Specification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/1 17:16
 * @Description
 */
@Mapper
public interface SpecificationMapper {

    public Integer totalCount(Map<String,Object> map);

    public List<Specification> getSpecificationPage(Map<String,Object> map);

    public Integer addSpecification(Specification specification);

    public Specification getSpecificationById(Integer id);

    public Integer updateSpecifictionById(Specification specification);

    public List<Specification> getSpecifications();

}
