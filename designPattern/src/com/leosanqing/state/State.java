package com.leosanqing.state;

/**
 * @Author: leosanqing
 * @Date: 2019-09-19 20:54
 */
public interface State {
    void doClock(Context context,int hour);
    void doUse(Context context);
    void doAlarm(Context context);
    void doPhone(Context context);
}
