package com.leosanqing.abstractfactory.tablefactory;

import com.leosanqing.abstractfactory.factory.Link;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 23:00
 */
public class TableLink extends Link {
    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "  <td><a href=\"" + url + "\">" + caption + "</td>";
    }
}
