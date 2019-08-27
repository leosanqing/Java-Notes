package com.leosanqing.factory;

import com.leosanqing.factory.framework.Factory;
import com.leosanqing.factory.framework.Product;
import com.leosanqing.factory.idcard.IDCardFactory;


/**
 * 我把我自己之前犯得错误写了出来(一开始我没发现，后来才看到)
 *
 * 一开始我没有使用工厂模式创建实例，而是使用我们最最常用的方法 new 一个对象
 *
 * 工厂方法不用 new 关键字来生成实例，而是调用生成实例的专用方法，
 * 目的是为了防止 父类和其他具体类耦合
 *
 *
 */
public class Test {
    public static void main(String[] args) {

        Factory factory = new IDCardFactory();
        Product p1 = factory.create("小明");
        Product p2 = factory.create("小红");
        Product p3 = factory.create("小黑");

//        Product p1 = new IDCard("小明");
//        Product p2 = new IDCard("小红");
//        Product p3 = new IDCard("小黑");

        p1.use();
        p2.use();
        p3.use();

    }
}
