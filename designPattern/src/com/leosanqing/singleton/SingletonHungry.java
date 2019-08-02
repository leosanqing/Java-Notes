package com.leosanqing.singleton;

/**
 * @Author: leosanqing
 * @Date: 2019-08-01 22:31
 */

/**
 * 饿汉式
 * 优点：不需要加锁，效率高
 * 缺点：内存资源浪费
 */
public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();
    private SingletonHungry(){}


    public static SingletonHungry getInstance(){
        return instance;
    }
}
