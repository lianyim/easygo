package com.easygo.testMybaties;

import com.easygo.mapper.ContentCategoryMapper;
import com.easygo.mapper.ContentMapper;
import com.easygo.pojo.Content;
import com.easygo.pojo.ContentCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/3/30 10:06
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMybaties {

    @Resource
    ContentCategoryMapper categoryMapper;
    @Test
    public void testDelete(){
        int i = categoryMapper.deleteContentCategory(1);
        System.out.println(i>0?"删除成功":"删除失败");
    }

    @Test
    public void testGetTotalCount(){
        String key="日";
        Map<String,Object> map=new HashMap<>();
        map.put("name","%"+key+"%");
        Integer totalConut = categoryMapper.getTotalCount(map);
        System.out.println("总数是："+totalConut);
    }

    @Resource
    ContentMapper contentMapper;

    @Test
    public void testGetTotal(){
        Integer totalCount = contentMapper.getTotalCount();
        System.out.println(totalCount);
    }

    @Test
    public void testGetContents(){
        List<Content> contents = contentMapper.getContentByCategoryId(1);
        for (Content content : contents) {
            System.out.println(content);
        }
    }

}
