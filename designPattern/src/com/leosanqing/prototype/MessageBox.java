package com.leosanqing.prototype;

import com.leosanqing.prototype.framework.Product;

/**
 * @Author: leosanqing
 * @Date: 2019-08-02 07:09
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
