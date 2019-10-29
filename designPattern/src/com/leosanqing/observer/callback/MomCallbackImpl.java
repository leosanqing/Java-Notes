package com.leosanqing.observer.callback;

/**
 * @Author: leosanqing
 * @Date: 2019-10-29 22:40
 */
public class MomCallbackImpl implements ICallBack {


    public void say(XiaoMing xiaoMing,String string){
        xiaoMing.work(this,string);
    }

    @Override
    public void setResult(String string) {
        System.out.println(string);
        eat();
    }

    private void eat() {
        System.out.println("好了，那就准备吃饭吧");
    }

}
