package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/4/1 17:05
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specification implements Serializable {

    private static final long serialVersionUID = 8837759180331415520L;

    private Integer id;
    private String spec_name;
    private String del;

    //扩展属性
    private Boolean flag=false;

}
