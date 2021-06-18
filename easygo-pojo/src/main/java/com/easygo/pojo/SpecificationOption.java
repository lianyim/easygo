package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Lym
 * @Date 2020/4/1 17:06
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecificationOption implements Serializable {

    private static final long serialVersionUID = 4522866958820850948L;

    private Integer id;
    private String option_name;
    private Specification specification;  // 外键对象
//    private Integer spec_id;
    private Integer orders;
    private Integer del;

}
