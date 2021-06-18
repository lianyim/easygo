package com.easygo.service;

import com.easygo.pojo.SpecificationOption;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/4 19:53
 * @Description
 */
public interface SpecificationOptionService {

    // 新增
    public int addSpecificationOption(SpecificationOption option);

    public List<SpecificationOption> getSpecificationOptionsBySpecificationId(Integer specificationId);

    public int deleteSpecifications(int spec_id);

}
