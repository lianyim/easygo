package com.easygo.service;

import com.easygo.pojo.Goods;

import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/18 14:35
 * @Description
 */
public interface GoodsService {

    //新增文档
    public Goods saveDocument(Goods goods);

    //批量新增
    public Iterable<Goods> saveDocuments(List<Goods> list);

    //根据id查询
    public Goods getDocumentById(Long id);

    //根据id更新
    public void updateDocumentById(Goods goods);

    //根据id删除
    public void deleteDocumentById(Long id);

    //全部删除
    public void deleteAllDocument();

}
