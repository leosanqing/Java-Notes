package com.leosanqing.proxy;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 10:04
 */
public class Main {
    public static void main(String[] args) {
        Printable proxy = new PrinterProxy("Alice");
        System.out.println("现在的名字是"+proxy.getPrinterName());

        proxy.setPrinterName("Bob");
        System.out.println("现在的名字是"+proxy.getPrinterName());

        proxy.print("leosanqing");
    }
}
