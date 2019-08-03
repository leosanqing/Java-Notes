package com.leosanqing.abstractFactory.factory;

/**
 * @Author: leosanqing
 * @Date: 2019-08-03 20:50
 */
public abstract class Item {
    protected String caption;

    public Item(String string){
        this.caption = string;
    }
    public abstract String makeHTML();

}
