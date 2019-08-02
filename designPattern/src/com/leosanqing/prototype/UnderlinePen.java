package com.leosanqing.prototype;

import com.leosanqing.prototype.framework.Product;

/**
 * @Author: leosanqing
 * @Date: 2019-08-02 07:15
 */
public class UnderlinePen implements Product {

    private char c;

    public UnderlinePen(char c) {
        this.c = c;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");

        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(c);
        }
        System.out.println();

    }

    @Override
    public Product createClone() {
        Product p = null;
        try{
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
