package com.leosanqing.iterator.ordinary;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 16:56
 */
public interface Aggregate<T> {
    Iterator<T> iterator();
}
