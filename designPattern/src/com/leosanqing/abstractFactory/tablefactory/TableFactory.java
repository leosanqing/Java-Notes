package com.leosanqing.abstractfactory.tablefactory;

import com.leosanqing.abstractfactory.factory.Factory;
import com.leosanqing.abstractfactory.factory.Link;
import com.leosanqing.abstractfactory.factory.Page;
import com.leosanqing.abstractfactory.factory.Tray;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 23:33
 */
public class TableFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title,author);
    }
}
