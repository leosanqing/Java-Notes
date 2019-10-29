package com.leosanqing.observer;

/**
 * @Author: leosanqing
 * @Date: 2019-10-29 08:01
 */
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("DigitObserver:" + numberGenerator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
