package com.leosanqing.factory;

import com.leosanqing.factory.framework.Product;
import com.leosanqing.factory.idcard.IDCard;

public class Test {
    public static void main(String[] args) {
        Product p1 = new IDCard("小明");
        Product p2 = new IDCard("小红");
        Product p3 = new IDCard("小黑");

        p1.use();
        p2.use();
        p3.use();

    }
}
