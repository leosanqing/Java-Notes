package com.leosanqing.strategy;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 10:17
 */
public class Main {
    public static void main(String[] args) {
        Player leosanqing = new Player("leosanqing", new WinningStrategy());
        Player pipi = new Player("pipi", new ProbStrategy());

    }
}
