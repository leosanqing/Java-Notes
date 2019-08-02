package com.leosanqing.prototype.framework;

/**
 * @Author: leosanqing
 * @Date: 2019-08-02 07:03
 */
public interface Product extends Cloneable{
    public void use(String s);
    public Product createClone();
}
