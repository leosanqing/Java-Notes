package com.leosanqing.observer;

import java.util.Random;

/**
 * @Author: leosanqing
 * @Date: 2019-10-29 08:00
 */
public class RandomNumberGenerator<T> extends NumberGenerator {
    private Random random = new Random();
    private int number;
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
