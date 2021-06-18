package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/4/5 21:02
 * @Description  授权管理 规格 品牌
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeTemplate implements Serializable {
    private static final long serialVersionUID = -1642254272758790944L;

    private  Integer id;
    private String name;
    private String spec_ids;
    private String brand_ids;
    private String custom_attribute_items;
    private Integer del;

}
