package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/4/20 16:40
 * @Description SKu的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    private static final long serialVersionUID = 7600452053730511747L;

    private Long id;
    private String title;
    private String sell_point;
    private Double price;
    private Long stock_count;
    private Long num;
    private String barcode;
    private String image;
    private Long categoryId;
    private String status;
    private String createTime;
    private String updateTime;
    private String item_sn;
    private Double cost_pirce;
    private Double market_price;
    private String is_default;
    private Long goods_id;
    private String seller_id;
    private String cart_thumbnail;
    private String category;
    private String brand;
    private String spec;
    private String seller;
}
