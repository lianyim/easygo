package com.easygo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/4/6 16:18
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attribute_items_bean implements Serializable {
    private static final long serialVersionUID = 3132434748379899314L;
    private String text;
}
