package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/3/27 10:13
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand implements Serializable {
    private static final long serialVersionUID = 5268136551205423998L;
    private Integer id;
    private String name;
    private String image;
    private String first_char;
    private Integer del;

    //扩展属性
    private Boolean flag=false;  //默认false
}
