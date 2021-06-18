package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/4/21 14:53
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {
    private static final long serialVersionUID = -9154794220196083345L;

    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String created;
    private String updated;
    private String source_type;
    private String nick_name;
    private String name;
    private String status;
    private String head_pic;
    private String qq;
    private double account_balance;
    private String is_email_check;
    private String is_mobile_check;
    private String sex;
    private Integer user_level;
    private Integer points;
    private Integer experience_value;
    private String birthday;
    private String last_login_time;
    private Integer del;

}
