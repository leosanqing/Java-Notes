package com.leosanqing.prototype.framework;

import java.util.HashMap;

/**
 * @Author: leosanqing
 * @Date: 2019-08-02 07:04
 */


/**
 *  在prototype模式中，我们是根据现有的实例来进行创建新的实例，但我们也没有使用new关键字
 *
 *  什么时候用 prototype呢？
 *      1. 对象种类繁多，不能整合到一个类中
 *      2.难以根据类生成实例(prototype根据现有类生成实例)
 *      3.想解耦框架与生成的实例时
 *
 *
 *  类名不一定是束缚，但是如果在代码中使用类名，就无法和该类分离开，无法实现复用
 */
public  class Manager {
    private HashMap<String,Product> showcase = new HashMap<>();

    public void register(String name,Product product){
        showcase.put(name, product);
    }

    public Product create(String protoname){
        Product p = showcase.get(protoname);
        return p.createClone();
    }

}
