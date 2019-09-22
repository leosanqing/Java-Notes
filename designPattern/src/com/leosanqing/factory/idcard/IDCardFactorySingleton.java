package com.leosanqing.factory.idcard;

import com.leosanqing.factory.framework.Factory;
import com.leosanqing.factory.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 21:14
 */
public class IDCardFactorySingleton extends Factory {
    private List<String> owners = new ArrayList<>();
    public volatile static IDCardFactorySingleton instance = null;

    private IDCardFactorySingleton(){}

    public static IDCardFactorySingleton getInstance(){
        if (instance == null) {
            synchronized (IDCardFactorySingleton.class){
                if (instance == null) {
                    instance = new IDCardFactorySingleton();
                }
            }
        }
        return instance;
    }

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }

    public List<String> getOwners(){
        return owners;
    }
}
