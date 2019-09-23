package com.leosanqing.abstractfactory.listfactory;

import com.leosanqing.abstractfactory.factory.Item;
import com.leosanqing.abstractfactory.factory.Tray;

import java.util.Iterator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 21:20
 */
public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<li>\n").append(caption).append("\n");
        buffer.append("<ul>\n");
        for (Item item : tray) {
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n").append("</li>\n");
        return buffer.toString();
    }
}
