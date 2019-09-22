package com.leosanqing.abstractfactory.listfactory;

import com.leosanqing.abstractfactory.factory.Link;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 21:13
 */
public class ListLink extends Link {
    public ListLink(String caption, String url) {
        super(caption, url);
    }
    @Override
    public String makeHTML() {
        return "   <li><a href=\"" + url + "\">" + caption + "</li>\n";
    }
}
