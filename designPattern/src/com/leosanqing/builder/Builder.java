package com.leosanqing.builder;

/**
 * @Author: leosanqing
 * @Date: 2019-08-03 19:50
 */
public abstract class Builder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String string);
    public abstract void makeItems(String[] items);
    public abstract void close();
}
