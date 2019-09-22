package com.leosanqing.abstractfactory.factory;

import java.util.ArrayList;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 20:40
 */
public abstract class Tray extends Item{
    protected ArrayList<Item> tray = new ArrayList<>();
    public Tray(String caption) {
        super(caption);
    }
    public void add(Item item){
        tray.add(item);
    }
}
