package com.leosanqing.abstractfactory.tablefactory;

import com.leosanqing.abstractfactory.factory.Item;
import com.leosanqing.abstractfactory.factory.Page;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 23:27
 */
public class TablePage extends Page {
    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>"+title+"</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>"+title+"</h1>\n");
        buffer.append("<table width=\"80%\" border =\"3\">\n");
        for (Item item : content) {
            buffer.append(item.makeHTML());
        }
        buffer.append("</table>\n");
        buffer.append("<hr><address>"+author+"</address>");
        buffer.append("</body></html>\n");
        return buffer.toString();
    }
}
