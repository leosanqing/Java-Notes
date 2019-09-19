package com.leosanqing.memento.game;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leosanqing
 * @Date: 2019-09-19 07:43
 */
public class Memento {
    int money;
    ArrayList<String> fruits ;
    public int getMoney(){
        return  money;
    }

    Memento(int money){
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    void addFruit(String fruit){
        fruits.add(fruit);
    }

    List<String> getFruits(){
        List<String> clone = (List<String>) fruits.clone();
        return clone;
    }
}
