package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/3/30 18:56
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content implements Serializable {
    private static final long serialVersionUID = 483384659958645312L;
    private Integer id;
    private ContentCategory contentCategory;  // 外键字段
    private String title;
    private String url;
    private String pic;
    private Integer status=0; //如果用户没有勾选，默认是0；勾选是1
    private Integer sort_order;
    private Integer del;
}
