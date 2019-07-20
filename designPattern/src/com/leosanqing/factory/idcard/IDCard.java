package com.leosanqing.factory.idcard;

import com.leosanqing.factory.framework.Product;

public class IDCard extends Product {
    private String owner;

    public IDCard(String owner){
        System.out.println("开始制作"+owner+ "的IDCard");
        this.owner = owner ;
    }

    @Override
    public void use() {
        System.out.println(owner+"开始使用IDCard");

    }

    public String getOwner(){
        return owner;
    }
}
