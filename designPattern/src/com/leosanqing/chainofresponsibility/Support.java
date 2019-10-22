package com.leosanqing.chainofresponsibility;

/**
 * @Author: leosanqing
 * @Date: 2019-10-22 08:15
 */
public abstract class Support {
    private String name;
    private Support next;

    // 生成实例
    protected Support(String name) {
        this.name = name;
    }

    // 要推卸给的对象
    public Support setNext(Support next){
        this.next = next;
        return next;
    }

    public 

}
