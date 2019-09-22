package com.leosanqing.adapter.trust;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 20:14
 */
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }
    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
