package com.leosanqing.factory.idcard;

import com.leosanqing.factory.framework.Factory;
import com.leosanqing.factory.framework.Product;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {
    private List owners = new ArrayList();
    @Override
    public Product createProduct(String string) {
        return new IDCard(string);
    }

    @Override
    public void registerProduct(Product product) {

        owners.add(((IDCard)product).getOwner());
    }

    public List getOwners(){
        return owners;
    }
}
