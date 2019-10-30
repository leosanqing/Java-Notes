package com.leosanqing.proxy;

/**
 * @Author: leosanqing
 * @Date: 2019-10-30 23:28
 */
public interface Printable {
    void setPrinterName(String name);
    void print(String string);
    String getPrinterName();
}
