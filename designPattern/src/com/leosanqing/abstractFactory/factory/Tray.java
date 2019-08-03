package com.leosanqing.abstractFactory.factory;

import java.util.ArrayList;

/**
 * @Author: leosanqing
 * @Date: 2019-08-03 20:58
 */
public abstract class Tray extends Item {
    protected ArrayList tray = new ArrayList();

    public Tray(String string) {
        super(string);
    }

    public void add(Item item){
        tray.add(item);
    }

}
