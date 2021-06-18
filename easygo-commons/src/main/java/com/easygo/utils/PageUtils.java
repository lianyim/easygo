package com.easygo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lym
 * @Date 2020/3/28 9:59
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageUtils<T> {
    private Integer pageIndex;  // 当前页码
    private Integer pageSize;  // 页码大小
    private Integer totalCount; // 总条数
    private  Integer pageCount;  // 总页数（计算所得）
    private List<T> records;  // 每页条数

    // 存储页面要显示的页码
    private List<Integer> numbers= new ArrayList<>();

    // 开始序号
    private  Integer numberStart=1;
    // 结束序号
    private Integer numberEnd;

    public PageUtils(Integer pageIndex, Integer pageSize, Integer totalCount, List<T> records) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.records = records;
        // 计算总页数
        this.pageCount=(this.totalCount%this.pageSize==0)?(this.totalCount/this.pageSize):(this.totalCount/this.pageSize+1);

        this.numberStart=1;
        this.numberEnd=this.pageCount;

        // 限制页码个数问题
        if (this.pageCount<=10){
            // 总页数不到10页
            this.numberStart=1;
            this.numberEnd=this.pageCount;
        }else {
            // 超过了10页
            this.numberStart=this.pageIndex-4;
            this.numberEnd=this.pageIndex+5;
            if (this.numberStart<1){
                this.numberStart=1;
                this.numberEnd=10;
            }else if (this.numberEnd>this.pageCount){
                this.numberEnd=this.getPageCount();
                this.numberStart=this.pageCount-9;
            }
        }

        for (int i=this.numberStart;i<=this.numberEnd;i++){
            numbers.add(i);
        }
    }
}
