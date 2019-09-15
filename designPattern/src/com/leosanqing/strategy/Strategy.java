package com.leosanqing.strategy;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 09:37
 */
public interface Strategy {
    Hand nextHand();
    void study(boolean bool);
}
