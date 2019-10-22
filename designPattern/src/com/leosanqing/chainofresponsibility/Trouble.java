package com.leosanqing.chainofresponsibility;

/**
 * @Author: leosanqing
 * @Date: 2019-10-22 08:12
 */
public class Trouble {
    private int num;

    public Trouble(int num) {
        this.num = num;
    }
    public int getNum(){
        return num;
    }

    @Override
    public String toString() {
        return "[Trouble" +
                 + num +
                "]";
    }
}
