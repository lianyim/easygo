package com.easygo.mapper;

import com.easygo.pojo.SpecificationOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/4 19:49
 * @Description
 */
@Mapper
public interface SpecificationOptionMapper {

    // 新增
    public int addSpecificationOption(SpecificationOption option);

    public List<SpecificationOption> getSpecificationOptionsBySpecificationId(Integer specificationId);

    public Integer updateSpecificationOption(SpecificationOption option);

    public int deleteSpecifications(int spec_id);

}
