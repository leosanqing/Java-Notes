package com.leosanqing.visitor;

/**
 * @Author: leosanqing
 * @Date: 2019-09-25 08:26
 */
public interface Element {
    void accept(Visitor visitor);
}
