package com.leosanqing.abstractFactory.factory;

/**
 * @Author: leosanqing
 * @Date: 2019-08-03 20:51
 */
public abstract class Link extends Item {
    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
