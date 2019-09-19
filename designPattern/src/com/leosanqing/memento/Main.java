package com.leosanqing.memento;

import com.leosanqing.memento.game.Gamer;
import com.leosanqing.memento.game.Memento;

/**
 * @Author: leosanqing
 * @Date: 2019-09-19 08:23
 */
public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();
        for (int i = 0; i < 100; i++) {
            System.out.println("===== "+i);
            System.out.println("当前状态： "+ gamer);

            gamer.bet();

            System.out.println("所持金钱数为"+gamer.getMoney()+"元");

            // 如何处理Memento
            if(gamer.getMoney() > memento.getMoney()){
                System.out.println("   （金钱数增加了，因此保存当前状态）");
                memento = gamer.createMemento();
            }else if(gamer.getMoney() < memento.getMoney()/2){
                System.out.println("    （金钱数减少了，因此将游戏恢复至以前的状态）");
                gamer.restoreMemento(memento);
            }


            try {
                Thread.sleep(1100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
