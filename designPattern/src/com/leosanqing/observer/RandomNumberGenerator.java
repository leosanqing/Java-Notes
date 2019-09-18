package com.leosanqing.observer;

import java.util.Random;

/**
 * @Author: leosanqing
 * @Date: 2019-09-18 22:30
 */
public class RandomNumberGenerator extends NumberGenerator {
    private int number;
    private Random random = new Random();

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}
