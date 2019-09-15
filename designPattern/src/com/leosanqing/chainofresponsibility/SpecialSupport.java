package com.leosanqing.chainofresponsibility;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 21:47
 */
public class SpecialSupport extends Support {
    private int number;
    public SpecialSupport(String name,int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number;
    }
}
