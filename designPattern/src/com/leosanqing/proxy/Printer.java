package com.leosanqing.proxy;

/**
 * @Author: leosanqing
 * @Date: 2019-09-21 18:26
 */
public class Printer implements Printable {
    private String name;


    public Printer(String name){
        heavyJob("正在生成Printer的实例" +name);

    }
    public Printer() {
        heavyJob("正在生成Printer的实例");
    }

    private void heavyJob(String msg) {
        System.out.println(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }

        System.out.println("finish ...");

    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        System.out.println("==== " + name + " ====");
        System.out.println(string);
    }
}
