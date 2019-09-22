package com.leosanqing.adapter.trust;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 20:15
 */
public class PrintBanner extends Print {
    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }


    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
