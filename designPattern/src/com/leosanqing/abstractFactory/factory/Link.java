package com.leosanqing.abstractfactory.factory;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 20:38
 */
public abstract class Link extends Item{
    protected String url;
    public Link(String caption,String url) {
        super(caption);
        this.url = url;
    }

}
