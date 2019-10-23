package com.leosanqing.chainofresponsibility;

/**
 * @Author: leosanqing
 * @Date: 2019-10-23 23:12
 */
public class SpecialSupport extends Support {
    private int num;
    protected SpecialSupport(String name,int num) {
        super(name);
        this.num = num;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNum() == num;
    }
}
