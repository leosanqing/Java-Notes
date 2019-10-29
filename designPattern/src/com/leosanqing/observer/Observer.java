package com.leosanqing.observer;

/**
 * @Author: leosanqing
 * @Date: 2019-10-29 07:48
 */
public interface Observer {
    /**
     * 更新数值
     * @param numberGenerator
     */
    void update(NumberGenerator numberGenerator);
}
