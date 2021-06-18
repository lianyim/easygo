package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/3/29 15:37
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    private static final long serialVersionUID = 1617086983756758639L;
    private Integer id;
    private String username;
    private String password;
    private String status;
    private Integer del;

}
