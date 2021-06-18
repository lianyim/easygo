package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/4/7 9:50
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCat implements Serializable {
    private static final long serialVersionUID = -6714833366105091846L;

    private Integer id;
    private Integer parent_id;
    private String name;
    private TypeTemplate typeTemplate;// 外键对应typeTemplate表
    private Integer del;
}
