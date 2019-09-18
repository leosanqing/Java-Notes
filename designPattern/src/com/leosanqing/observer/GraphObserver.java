package com.leosanqing.observer;

/**
 * @Author: leosanqing
 * @Date: 2019-09-18 22:33
 */
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.print("GraphGenerator:");
        for (int i = 0; i < generator.getNumber(); i++) {
            System.out.print('*');
        }
        System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
