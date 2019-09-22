package com.leosanqing.proxy;

/**
 * @Author: leosanqing
 * @Date: 2019-09-21 18:23
 */
public interface Printable {
    void setPrinterName(String name);
    String getPrinterName();
    void print(String string);
}
