package com.leosanqing.adapter.extend;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 17:54
 *
 * 这是使用继承来实现 Adapter。等下看下二者的区别
 */
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
