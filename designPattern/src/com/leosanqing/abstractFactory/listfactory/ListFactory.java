package com.leosanqing.abstractfactory.listfactory;

import com.leosanqing.abstractfactory.factory.Factory;
import com.leosanqing.abstractfactory.factory.Link;
import com.leosanqing.abstractfactory.factory.Page;
import com.leosanqing.abstractfactory.factory.Tray;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 21:11
 *
 * ListFactory 只是抽象工厂的其中一个实现工厂，功能是输出列表样式
 */
public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title,author);
    }
}
