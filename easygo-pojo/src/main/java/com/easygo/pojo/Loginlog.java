package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/3/29 20:49
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loginlog implements Serializable {
    private static final long serialVersionUID = -2366954401265203324L;
    private Integer id;
    private String ip;
    private String no;  // 登录账号
    private String createtime;
    private String location;

    public Loginlog(String ip, String no, String location) {
        this.ip = ip;
        this.no = no;
        this.location = location;
    }
}
