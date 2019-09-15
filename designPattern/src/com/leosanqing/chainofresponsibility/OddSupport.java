package com.leosanqing.chainofresponsibility;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 21:45
 *
 * 处理奇数
 */

public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() % 2 == 1;
    }
}
