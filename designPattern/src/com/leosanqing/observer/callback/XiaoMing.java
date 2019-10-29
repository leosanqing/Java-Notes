package com.leosanqing.observer.callback;

/**
 * @Author: leosanqing
 * @Date: 2019-10-29 22:37
 */
public class XiaoMing  {
    private ICallBack iCallBack;


    public void work(ICallBack iCallBack,String string) {
        this.iCallBack = iCallBack;
        System.out.println(string);
        System.out.println("收到了，马上去");
    }


    public void workDown(String string){
        if(iCallBack!=null){
            iCallBack.setResult(string);
        }
    }
}
