package com.easygo.service.impl;

import com.easygo.mapper.SpecificationOptionMapper;
import com.easygo.pojo.SpecificationOption;
import com.easygo.service.SpecificationOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/4 19:54
 * @Description
 */
@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

    @Resource
    SpecificationOptionMapper specificationOptionMapper;

    @Override
    public int addSpecificationOption(SpecificationOption option) {
        return specificationOptionMapper.addSpecificationOption(option);
    }

    @Override
    public List<SpecificationOption> getSpecificationOptionsBySpecificationId(Integer specificationId) {
        return specificationOptionMapper.getSpecificationOptionsBySpecificationId(specificationId);
    }

    @Override
    public int deleteSpecifications(int spec_id) {
        return specificationOptionMapper.deleteSpecifications(spec_id);
    }
}
