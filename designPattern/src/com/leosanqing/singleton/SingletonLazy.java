package com.leosanqing.singleton;

/**
 * @Author: leosanqing
 * @Date: 2019-08-01 22:21
 */

/**
 * 懒汉式，
 * 优点：延迟加载，避免内存浪费
 * 缺点：加锁，效率低
 */
public class SingletonLazy {
    private static SingletonLazy instance;
    private SingletonLazy(){}

    public static synchronized SingletonLazy getInstance(){
        if(null==instance) {
            instance = new SingletonLazy();
        }
        return instance;
    }

}
