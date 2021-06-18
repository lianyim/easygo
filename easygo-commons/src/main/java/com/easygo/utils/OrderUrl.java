package com.easygo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/4/20 11:25
 * @Description 扩展对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderUrl implements Serializable {
    private static final long serialVersionUID = -7261707654827273755L;

    private Integer order;
    private String url;

}
