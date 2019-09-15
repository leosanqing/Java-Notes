package com.leosanqing.visitor;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 20:09
 */
public interface Element {
    void accept(Visitor v);
}
