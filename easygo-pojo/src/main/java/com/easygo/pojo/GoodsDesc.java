package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/4/20 10:44
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDesc implements Serializable {
    private static final long serialVersionUID = 6322756092193949548L;
    private Long goods_id; //商品ID
    private String introduction; //商品详情介绍
    private String specification_items; //商品规格属性
    private String custom_attribute_items;//扩展属性
    private String package_list; //包装列表
    private String sale_service; //售后详情
    private String item_images; //商品图片集合
}
