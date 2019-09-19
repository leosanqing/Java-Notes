package com.leosanqing.memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: leosanqing
 * @Date: 2019-09-19 07:50
 */
public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList<>();
    private Random random = new Random();
    private static String[] fruitsName = {
            "苹果", "香蕉", "椰子", "橘子"
    };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;

        if (dice == 1) {
            money += 100;
        } else if (dice == 2) {
            money /= 2;
        } else if (dice == 6) {
            String fruit = getFruit();
            System.out.println(" 获得了水果（" + fruit + "）");
            fruits.add(fruit);
        } else {
            System.out.println("什么也没有发生");
        }
    }


    public Memento createMemento() {
        Memento memento = new Memento(money);
        for (String fruit : fruits) {
            if (fruit.startsWith("好吃的")) {
                memento.addFruit(fruit);
            }
        }
        return memento;
    }

    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "好吃的";
        }
        return prefix + fruitsName[random.nextInt(fruitsName.length)];
    }

    public String toString() {
        return "[money = " + money + ",fruit = " + fruits + "]";
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }
}
