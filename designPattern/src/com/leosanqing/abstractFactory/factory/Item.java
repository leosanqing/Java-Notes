package com.leosanqing.abstractfactory.factory;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 20:35
 *
 * Item 类是Link 和Tray的父类。
 *      作用: 1.声明Link 和Tray的公共方法
 *           2.为了后面的传参（如add方法），因为我并不必要知道是哪一个，我只要知道是其中一个就行
 *
 */
public abstract class Item {
    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }

    public abstract String makeHTML();
}
