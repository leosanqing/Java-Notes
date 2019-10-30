package com.leosanqing.flyweight;

import java.util.HashMap;

/**
 * @Author: leosanqing
 * @Date: 2019-09-21 10:26
 */
public class BigCharFactory {

//    enum Singleton{
//        INSTANCE;
//        private BigCharFactory instance;
//        private BigCharFactory getInstance(){
//
//        }
//    }

    private HashMap<String, BigChar> pool = new HashMap<>();

    private static BigCharFactory instance = null;

    private BigCharFactory() {
    }


    public static BigCharFactory getInstance() {
        if (instance == null) {
            synchronized (BigCharFactory.class) {
                if (instance == null) {
                    instance = new BigCharFactory();
                }
            }
        }
        return instance;
    }

    /**
     * 使用 synchronized 可以防止 多线程情况下 new 出多个实例
     */
    public synchronized BigChar getBigChar(char charName) {
        BigChar bigChar = pool.get(charName + "");
        if (bigChar == null) {
            bigChar = new BigChar(charName);
            pool.put(charName + "", bigChar);
        }
        return bigChar;
    }

}
