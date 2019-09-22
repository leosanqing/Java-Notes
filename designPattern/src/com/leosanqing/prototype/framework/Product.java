package com.leosanqing.prototype.framework;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 21:53
 */
public interface Product extends Cloneable{
    void use(String s);
    Product createClone();
}
