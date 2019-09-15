package com.leosanqing.bridge;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 08:38
 * |
 * Bridge方法是将类的功能层次和类的实现层次相分离的模式
 *
 * 我们看这个Display类，他的这些方法实质上调用的是 DisplayImpl类的方法
 *
 * 看到这个有没有想到之前我们学过的Adapter模式的委托方法。
 *
 * 除了没有提前将它的各种方法声明，其实都是一样，
 *
 * 看这个像不像是 Adapter + Template 模式
 */
public  class Display {
    private DisplayImpl display;

    public Display(DisplayImpl display){
        this.display = display;
    }

    public void open(){
        display.rawOpen();
    }
    public final void display(){
        open();
        print();
        close();
    }

    public void close() {
        display.rawClose();
    }

    public void print() {
        display.rawPrint();
    }
}
