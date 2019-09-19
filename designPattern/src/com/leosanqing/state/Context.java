package com.leosanqing.state;

/**
 * @Author: leosanqing
 * @Date: 2019-09-19 20:55
 */
public interface Context {
    void setClock(int hour);
    void changeState(State state);
    void callSecurityCenter(String msg);
    void recordLog(String msg);
}
