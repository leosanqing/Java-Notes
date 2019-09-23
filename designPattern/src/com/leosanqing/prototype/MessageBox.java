package com.leosanqing.prototype;

import com.leosanqing.prototype.framework.Product;

/**
 * @Author: leosanqing
 * @Date: 2019-09-23 07:09
 */
public class MessageBox implements Product {
    private char c;

    public MessageBox(char c) {
        this.c = c;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length + 4; i++) {
            System.out.print(c);
        }
        System.out.println();
        System.out.println(c + " " + s + " " + c);
        for (int i = 0; i < length + 4; i++) {
            System.out.print(c);
        }
        System.out.println();
    }

    // 因为 MessageBox是Product的子类，所以可以强转为Product，
    // 并在Manager类中使用Product 接收 MessageBox 和UnderlinePane
    @Override
    public Product createClone() {
        Product p = null;
        try {
             p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
