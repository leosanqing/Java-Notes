package com.leosanqing.iterator.ordinary;


// Iterator 是一个接口，里面定义了我们需要的两个方法，
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
