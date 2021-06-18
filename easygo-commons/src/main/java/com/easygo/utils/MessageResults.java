package com.easygo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Lym
 * @Date 2020/3/27 18:24
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResults {
    private Integer code;
    private String message;
}
