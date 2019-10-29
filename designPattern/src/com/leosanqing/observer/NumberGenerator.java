package com.leosanqing.observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: leosanqing
 * @Date: 2019-10-29 07:48
 */
public abstract class NumberGenerator<T extends Observer> {
    private ArrayList<T> observers = new ArrayList();
    public void addObserver(T observer){
        observers.add(observer);
    }

    public void deleteObserver(T observer){
        observers.remove(observer);
    }

    /**
     *  发送通知
     */
    public void notifyObservers(){
        Iterator iterator = observers.iterator();
        while(iterator.hasNext()){
            T next = (T)iterator.next();
            next.update(this);
        }
    }


    /**
     * 使用更简单的  foreach
     */
    public void notifyObservers1(){
        for (T observer : observers) {
            observer.update(this);
        }

    }

    /**
     * 获取数值
     * @return
     */
    public abstract int getNumber();

    /**
     * 生成数值
     */
    public abstract void execute();



}
