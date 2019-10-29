package com.leosanqing.observer;

/**
 * @Author: leosanqing
 * @Date: 2019-10-29 08:03
 */
public class GraphObserver implements  Observer{

    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.print("GraphObserver: ");
        for (int i = 0; i < numberGenerator.getNumber(); i++) {
            System.out.print("*");
        }
        System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
