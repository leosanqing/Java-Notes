package com.leosanqing.chainofresponsibility;

/**
 * @Author: leosanqing
 * @Date: 2019-10-23 23:10
 */

public class LimitSupport extends Support {
    private int limit;

    protected LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {

        return trouble.getNum() < limit;
    }
}
