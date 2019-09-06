package com.leosanqing.builder;

/**
 * @Author: leosanqing
 * @Date: 2019-09-06 21:42
 * builder 模式中，我们在这个类中声明所有的方法
 */
public abstract class Builder {
    // 创建标题
    public abstract void makeTitle(String title);
    // 创建字符串
    public abstract void makeString(String str);
    // 创建 条目
    public abstract void makeItems(String[] items);
    public abstract void close();
}
