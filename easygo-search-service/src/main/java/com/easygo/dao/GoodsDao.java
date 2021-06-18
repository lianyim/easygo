package com.easygo.dao;

import com.easygo.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Lym
 * @Date 2020/4/17 20:04
 * @Description 是ES的dao层
 * ElasticsearchRepository是Spring Data ES内置接口，可以继承很多有用的方法，直接使用
 *
 * 专门操作ES服务器索引库的方法
 */
@Repository
public interface GoodsDao extends ElasticsearchRepository<Goods,Long> {

    //这个Dao里面可以什么都不写，可以直接使用父类中的方法

}
