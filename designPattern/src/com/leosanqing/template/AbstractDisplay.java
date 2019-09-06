package com.leosanqing.template;


/**
 * 父类中定义后续的逻辑，并给出子类需要重写的方法。
 *
 * 子类根据父类中定义的函数，实现自己需要的逻辑。
 *
 * 请一定要弄清楚这个模式，因为后面的模式中会大量用到这个模式
 */
public abstract class AbstractDisplay {
    public abstract void open();

    public abstract void print();

    public abstract void close();

    // 为了不让子类重写父类的这个方法
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
