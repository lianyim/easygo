package com.easygo.test;

import com.easygo.mapper.SpecificationMapper;
import com.easygo.pojo.Specification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author Lym
 * @Date 2020/4/4 20:24
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestNyBatis {

    @Resource
    SpecificationMapper specificationMapper;

    @Test
    public void testId(){
        Specification specification = new Specification();
        specification.setSpec_name("测试返回主键");
        Integer count = specificationMapper.addSpecification(specification);
        if (count>0){
            System.out.println("新增成功，ID是："+specification.getId());
        }
    }

}
