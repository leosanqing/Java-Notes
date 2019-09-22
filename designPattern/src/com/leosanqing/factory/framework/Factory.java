package com.leosanqing.factory.framework;


/**
 * @Author: leosanqing
 * @Date: 2019-09-22 20:30
 */
public abstract class Factory {
    // 这里使用Template模式
    public final Product create(String owner){
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
