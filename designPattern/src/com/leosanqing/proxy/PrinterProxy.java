package com.leosanqing.proxy;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 09:57
 */
public class PrinterProxy implements Printable {
    private String name;
    private Printer real;

    public PrinterProxy(String name){
        this.name = name;
    }
    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
    }

    private synchronized void realize() {
        if(real == null)
            real = new Printer(name);

    }
}
