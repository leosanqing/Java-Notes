package com.leosanqing.proxy;

import com.leosanqing.adapter.trust.Print;

/**
 * @Author: leosanqing
 * @Date: 2019-10-30 23:30
 */
public class Printer implements Printable {
    private String name;

    public Printer() {
        heavyJob("正在生成Printer的实例");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("正在生成Printer的实例(" + name + ")");
    }

    private void heavyJob(String s) {
        System.out.println(s);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("finish");
    }


    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public void print(String string) {
        System.out.println("===" + name + "===");
        System.out.println(string);

    }

    @Override
    public String getPrinterName() {
        return name;
    }
}
