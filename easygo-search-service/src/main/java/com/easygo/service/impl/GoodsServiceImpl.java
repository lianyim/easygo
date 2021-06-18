package com.easygo.service.impl;

import com.easygo.dao.GoodsDao;
import com.easygo.pojo.Goods;
import com.easygo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author Lym
 * @Date 2020/4/18 14:36
 * @Description
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public Goods saveDocument(Goods goods) {
       return goodsDao.save(goods);
    }

    @Override
    public Iterable<Goods> saveDocuments(List<Goods> list) {
        return goodsDao.saveAll(list);
    }

    @Override
    public Goods getDocumentById(Long id) {
        Optional<Goods> optional = goodsDao.findById(id);
        return optional.get();
    }

    @Override
    public void updateDocumentById(Goods goods) {
        goodsDao.save(goods);  //如果对象上有id就更新
    }

    @Override
    public void deleteDocumentById(Long id) {
        goodsDao.deleteById(id);
    }

    @Override
    public void deleteAllDocument() {
        goodsDao.deleteAll();
    }
}
