package com.leosanqing.enums;

import lombok.Getter;

/**
 * @Author: leosanqing
 * @Date: 2020/1/16 上午8:26
 * @Package: com.leosanqing.cart
 * @Description: 分类枚举
 */
public enum CategoryEnum {
    FOOD(10,"食品"),
    CLOTHING(20,"衣服"),
    BOOK(30,"图书"),
    ELECTRONIC(40,"电子"),


    ;
    private int code;
    private String name;

    CategoryEnum(int code,String name){
        this.code = code;
        this.name = name;
    }
}
