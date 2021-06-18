package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author Lym
 * @Date 2020/4/20 17:00
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkuBean implements Serializable {
    private static final long serialVersionUID = -2855162301271192456L;
    private Long id;
    private String title;
    private Double price;
    private Map<String,Object> spec;  //规格
}
