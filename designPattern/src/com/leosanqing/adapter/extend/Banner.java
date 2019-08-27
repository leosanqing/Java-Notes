package com.leosanqing.adapter.extend;

/**
 * 使用继承的方式
 *
 * 可以实现一个接口，并且继承一个类
 *
 *
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
