package com.leosanqing.proxy;

/**
 * @Author: leosanqing
 * @Date: 2019-10-30 23:36
 */
public class ProxyPrinter implements Printable {
    private String name;
    private Printable realPrinter;

    public ProxyPrinter(String name) {
        this.name = name;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        if (realPrinter != null) {
            realPrinter.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public void print(String string) {
        realize();
        realPrinter.print(string);
    }

    private void realize() {
        if (realPrinter == null) {
            realPrinter = new Printer(name);
        }
    }

    @Override
    public String getPrinterName() {
        return name;
    }
}
