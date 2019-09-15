package com.leosanqing.chainofresponsibility;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 21:42
 */
public class NoSupport extends Support{
    public NoSupport(String name){
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
