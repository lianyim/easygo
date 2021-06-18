package com.easygo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Lym
 * @Date 2020/4/20 15:39
 * @Description 规格对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeNameObject implements Serializable {

    private static final long serialVersionUID = -5558028184287353576L;
    private String attributeName;
    private List<String> attributeValue;

}
