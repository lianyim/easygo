package com.easygo.service.impl;

import com.easygo.mapper.SpecificationMapper;
import com.easygo.mapper.SpecificationOptionMapper;
import com.easygo.pojo.Specification;
import com.easygo.pojo.SpecificationOption;
import com.easygo.service.SpecificationOptionService;
import com.easygo.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/1 17:24
 * @Description
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Resource
    SpecificationMapper specificationMapper;

    @Autowired
    SpecificationOptionService specificationOptionService;

    @Override
    public Integer totalCount(Map<String, Object> map) {
        return specificationMapper.totalCount(map);
    }

    @Override
    public List<Specification> getSpecificationPage(Map<String, Object> map) {
        return specificationMapper.getSpecificationPage(map);
    }

    @Override
    public Integer addSpecification(Specification specification) {
        return specificationMapper.addSpecification(specification);
    }

    /**
     * 事务方法
     * @param spec_name
     * @param option_name
     * @param orders
     * @return
     *
     * 面试题：
     * ---------------------------------
     * 事务的7大传播特性
     * 事务的4大隔离级别
     * 事务的只读属性
     * 事务的超时机制
     * 事务回滚 rollbackFor noRollbackFor
     * ----------------------------------
     */
    @Override
    @Transactional
    public Integer addSpecificationTransaction(String spec_name, String[] option_name, Integer[] orders) {

        Specification specification = new Specification();
        specification.setSpec_name(spec_name);
        // specification还没有新增到数据库之前，是没有生成id的
        specificationMapper.addSpecification(specification);
        System.out.println("新增specification成功，ID值是："+specification.getId());

        // 模拟异常
        System.out.println(100/0);

        // 规格详情表
        for (int i=0;i<option_name.length;i++) {
            SpecificationOption option = new SpecificationOption();
            option.setOption_name(option_name[i]);
            option.setOrders(orders[i]);
            // 外键，为了新增的时候 把外键的id新增到数据库   第一张表新增成功之后返回的id 在第二张表中需要使用
            option.setSpecification(specification);

            specificationOptionService.addSpecificationOption(option);
        }
        return 1;
    }

    @Override
    public Specification getSpecificationById(Integer id) {
        return specificationMapper.getSpecificationById(id);
    }

    @Override
    @Transactional
    public Integer specification_update(Integer id, String spec_name, String[] option_name, Integer[] orders) {

        // 规格表对象
        Specification specification = new Specification();
        specification.setSpec_name(spec_name);
        specification.setId(id);
        specificationMapper.updateSpecifictionById(specification);
        // 用户的选项 新增 删除
        specificationOptionService.deleteSpecifications(id);

        // 规格详情表
        for (int i=0;i<option_name.length;i++) {
            SpecificationOption option = new SpecificationOption();
            option.setOption_name(option_name[i]);
            option.setOrders(orders[i]);
            // 外键，为了新增的时候 把外键的id新增到数据库   第一张表新增成功之后返回的id 在第二张表中需要使用
            option.setSpecification(specification);

            specificationOptionService.addSpecificationOption(option);
        }

        return 1;
    }

    @Override
    public List<Specification> getSpecifications() {
        return specificationMapper.getSpecifications();
    }
}
