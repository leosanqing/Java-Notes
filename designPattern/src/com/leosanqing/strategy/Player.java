package com.leosanqing.strategy;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 10:07
 */
public class Player {
    private String name;
    private Strategy strategy;
    private int winCount;
    private int loseCount;
    private int gameCount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand() {
        return strategy.nextHand();
    }

    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }

    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }

    public void even() {
        strategy.study(false);
        gameCount++;
    }

    public String toString() {
        return "[" + name + ":" + gameCount + " games, "
                + winCount + " win, " + loseCount + " lose" + "]";
    }
}
