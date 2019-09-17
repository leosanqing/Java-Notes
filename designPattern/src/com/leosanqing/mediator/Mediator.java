package com.leosanqing.mediator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-17 08:14
 *
 * Mediator 这个模式挺重要的，在 MQ或者其他订阅模式中，我们有用到
 */
public interface Mediator {
    void createColleagues();
    void colleagueChanged();
}
