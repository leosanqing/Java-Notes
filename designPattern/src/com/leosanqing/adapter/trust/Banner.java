package com.leosanqing.adapter.trust;

/**
 * 使用委托的方式，由另一个类去完成
 *
 * 因为Java只能单继承，因此只能继承一个类，然后在这个类中注入之前的类
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
