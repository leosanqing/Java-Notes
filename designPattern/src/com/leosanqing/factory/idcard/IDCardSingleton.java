package com.leosanqing.factory.idcard;

import com.leosanqing.factory.framework.Product;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 20:56
 */
public class IDCardSingleton extends Product {
    private String owner;

    public static volatile IDCardSingleton instance = null;

    private IDCardSingleton() {
    }

    public static IDCardSingleton getInstance() {
        if (instance == null) {
            synchronized (IDCardSingleton.class) {
                if (instance == null) {
                    instance = new IDCardSingleton();
                }
            }
        }
        return instance;
    }


    @Override
    public void use() {
        System.out.println("正在使用" + owner + "的IDCard");
    }

    public String getOwner() {
        return owner;
    }
}
