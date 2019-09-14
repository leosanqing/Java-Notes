package com.leosanqing.abstractFactory.listfactory;

import com.leosanqing.abstractFactory.factory.Item;
import com.leosanqing.abstractFactory.factory.Tray;

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
        Iterator<Item> iterator = tray.iterator();
        while(iterator.hasNext()){
            buffer.append(iterator.next().makeHTML());
        }
        buffer.append("</ul>\n").append("</li>\n");
        return buffer.toString();
    }
}
