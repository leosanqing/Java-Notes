package com.leosanqing.abstractFactory.tablefactory;

import com.leosanqing.abstractFactory.factory.Factory;
import com.leosanqing.abstractFactory.factory.Link;
import com.leosanqing.abstractFactory.factory.Page;
import com.leosanqing.abstractFactory.factory.Tray;

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
