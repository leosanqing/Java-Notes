package com.leosanqing.singleton;

/**
 * @Author: leosanqing
 * @Date: 2019-08-01 22:33
 */

/**
 * 双重校验锁
 *
 * 优点：可以在多线程下保持高性能
 * 缺点：复杂，没必要,并且很多写的也并不是线程安全的；
 *
 *
 * 很多例子都是这样写的，但是在并发编程的艺术中，明确说，这样子的其实并不是安全的。我们需要修改一下变量
 *
 * 如果要详细看原因，可以看我这篇文章
 */

public class DoubleCheckLock {

    private static DoubleCheckLock instance;

    private DoubleCheckLock(){}

    public static DoubleCheckLock getInstance(){
        if(null == instance){
            synchronized (instance){
                if(null == instance){
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }
}

/**
 * 这种的才是严格意义上的线程安全的单例
 */
 class DoubleCheckLock1 {

    private static volatile DoubleCheckLock1 instance;

    private DoubleCheckLock1(){}

    public static DoubleCheckLock1 getInstance(){
        if(null == instance){
            synchronized (instance){
                if(null == instance){
                    instance = new DoubleCheckLock1();
                }
            }
        }
        return instance;
    }
}