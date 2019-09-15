package com.leosanqing.bridge;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 08:49
 */
public class StringDisplay extends DisplayImpl {
    private String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public void rawOpen() {
        System.out.println("open......");
    }

    @Override
    public void rawPrint() {
        System.out.println(string);
    }

    @Override
    public void rawClose() {
        System.out.println("close......");
    }
}
