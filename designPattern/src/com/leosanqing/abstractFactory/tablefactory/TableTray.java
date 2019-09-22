package com.leosanqing.abstractfactory.tablefactory;

import com.leosanqing.abstractfactory.factory.Item;
import com.leosanqing.abstractfactory.factory.Tray;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 23:18
 */
public class TableTray extends Tray {
    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<td>");
        buffer.append("<table width=\"100%\" border=\"1\"><tr>");
        buffer.append("<td bgcolor=\"#cccccc\" align=\"center\"> colspan=\"").append(tray.size()).append("\"><b>").append(caption).append("</b></td>");
        buffer.append("</tr>\n");
        buffer.append("<tr>\n");
        for (Item item : tray) {
            buffer.append(item.makeHTML());
        }
        buffer.append("</tr></table>");
        buffer.append("<td>");
        return buffer.toString();
    }
}
