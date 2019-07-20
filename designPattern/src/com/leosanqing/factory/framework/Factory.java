package com.leosanqing.factory.framework;

public abstract class Factory {
    public final Product create(String string){
        Product product = createProduct(string);
        registerProduct(product);
        return product;
    }
    public abstract Product createProduct(String string);
    public abstract void registerProduct(Product product);

}
