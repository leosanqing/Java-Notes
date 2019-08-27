package com.leosanqing.factory.framework;


/**
 * 工厂模式中使用了模板模式，但是有更进一步添加了创建实例的方法
 */
public abstract class Factory {
    public final Product create(String string) {
        Product product = createProduct(string);
        registerProduct(product);
        return product;
    }

    public abstract Product createProduct(String string);

    public abstract void registerProduct(Product product);

}
