package com.leosanqing.state;

/**
 * @Author: leosanqing
 * @Date: 2019-09-19 21:28
 */
public class NightState implements State {
    public static volatile NightState instance = null;

    private NightState() {
    }

    public static NightState getInstance() {
        if (null == instance) {
            synchronized (NightState.class) {
                if (null == instance) {
                    instance = new NightState();
                }
            }
        }
        return instance;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour > 9 && hour <= 17) {
            context.changeState(DayState.instance);
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("紧急：晚上使用金库！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃（晚上）");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("晚上的通话录音");
    }

    public String toString(){
        return "[晚上]";
    }
}
