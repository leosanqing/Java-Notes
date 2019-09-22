package com.leosanqing.prototype;

import com.leosanqing.prototype.framework.Manager;
import com.leosanqing.prototype.framework.Product;

/**
 * @Author: leosanqing
 * @Date: 2019-08-02 07:20
 */
public class Test {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('~');
        MessageBox messageBox = new MessageBox('*');
        MessageBox messageBox1 = new MessageBox('/');

        manager.register(Name.UNDERLINE.getName(),underlinePen);
        manager.register(Name.WARNING_MSG.getName(),messageBox);
        manager.register(Name.STRONG_MSG.getName(),messageBox1);

        Product p1 = manager.create(Name.UNDERLINE.getName()); 
        p1.use("Hello World");
        Product p2 = manager.create(Name.STRONG_MSG.getName());
        p2.use("Hello World");
        Product p3 = manager.create(Name.WARNING_MSG.getName());
        p3.use("Hello World");

    }
}
