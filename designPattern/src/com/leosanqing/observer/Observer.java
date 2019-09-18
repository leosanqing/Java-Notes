package com.leosanqing.observer;

/**
 * @Author: leosanqing
 * @Date: 2019-09-18 22:25
 *
 * 发布-订阅 模式。可能更符合他的行为
 *
 * 我们来看Generator的行为，他每执行一次之后，他就会在最后通知一下Observer，更新他的信息
 *
 * 所以并不是观察者主动观察，而是 Generator 通知。是一个被动的过程
 *
 * 就像我们手机上的订阅，或者你点了我的 watch，这样之后，当我更新了新的东西，就像程序
 * 里面的，执行了 execute 函数之后，你才能收到消息(被 notify)
 */
public interface Observer {
    void update(NumberGenerator generator);
}
