package com.leosanqing.observer.callback;

/**
 * @Author: leosanqing
 * @Date: 2019-10-29 22:47
 */
public class Main {
    public static void main(String[] args) {
        MomCallbackImpl momCallback = new MomCallbackImpl();
        XiaoMing xiaoMing = new XiaoMing();
        momCallback.say(xiaoMing,"小明，去叫你爸爸吃饭");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        xiaoMing.workDown("爸爸叫回来了");
    }
}
