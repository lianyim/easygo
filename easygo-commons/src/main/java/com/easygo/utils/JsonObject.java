package com.easygo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/4/5 22:02
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonObject implements Serializable {
    private static final long serialVersionUID = 754470995104028500L;
    private Integer id;
    private String text;
}
