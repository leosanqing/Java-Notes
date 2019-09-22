package com.leosanqing.iterator.ordinary;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 16:54
 */
public interface Iterator<T> {
    T next();
    boolean hasNext();
}
