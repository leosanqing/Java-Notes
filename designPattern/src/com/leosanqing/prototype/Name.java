package com.leosanqing.prototype;

/**
 * @Author: leosanqing
 * @Date: 2019-08-02 07:23
 */
public enum Name {

    UNDERLINE("underline"),
    STRONG_MSG("StrongMsg"),
    WARNING_MSG("WarningMsg");

    private String name;


    Name(String s){
        name =s;
    }

    public String getName() {
        return name;
    }
}
