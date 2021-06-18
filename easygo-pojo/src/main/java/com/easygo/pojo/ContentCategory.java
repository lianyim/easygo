package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/3/30 9:54
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentCategory implements Serializable {
    private static final long serialVersionUID = 836139326489519277L;
    private Integer id;
    private String name;
    private Integer del;
}
