package com.leosanqing.decorator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 19:24
 *
 * 在这里 这个 Border也使用了 委托
 *
 * 但是委托的具体动作交给了 子类实现
 */
public abstract class Border extends Display {
    protected Display display;
    protected Border(Display display){
        this.display = display;
    }
}
