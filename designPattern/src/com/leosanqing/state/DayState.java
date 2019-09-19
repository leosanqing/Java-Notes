package com.leosanqing.state;

/**
 * @Author: leosanqing
 * @Date: 2019-09-19 21:23
 *
 * 因为每次创建一个实例会浪费很多内存，所以使用单例
 */
public class DayState implements State{
    public static volatile DayState instance = null;
    private DayState (){}

    public DayState getInstance(){
        if(null == instance){
            synchronized (DayState.class){
                if(null == instance){
                    instance = new DayState();
                }
            }
        }
        return instance;
    }
    @Override
    public void doClock(Context context, int hour) {
        if(hour <= 9 || hour>17){
            context.changeState(NightState.instance);
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("使用金库（白天）");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃（白天）");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("晚上的通话录音");
    }


    public String toString(){
        return "[白天]";
    }
}
