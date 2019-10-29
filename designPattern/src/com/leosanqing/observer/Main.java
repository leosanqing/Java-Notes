package com.leosanqing.observer;

/**
 * @Author: leosanqing
 * @Date: 2019-09-18 22:36
 */
public class Main {
    public static void main(String[] args) {
        NumberGenerator<Observer> generator = new RandomNumberGenerator<>();
        Observer digitObserver = new DigitObserver();
        Observer graphObserver = new GraphObserver();
        generator.addObserver(digitObserver);
        generator.addObserver(graphObserver);
        generator.execute();
    }
}
