package com.leosanqing.factory.idcard;


import com.leosanqing.factory.framework.Product;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 20:44
 */
public class IDCard extends Product {
    private String owner;

    //  因为防止外面直接new实例
    IDCard(String owner) {
        System.out.println("制作" + owner + "的IDCard");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("正在使用" + owner + "的ID卡");
    }

    public String getOwner() {
        return owner;
    }
}
