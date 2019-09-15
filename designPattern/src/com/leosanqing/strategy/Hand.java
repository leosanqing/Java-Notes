package com.leosanqing.strategy;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 09:38
 * <p>
 * 这里使用了单例模式，看出来了吗？
 */
public class Hand {
    public static final int HANDVALUE_GUU = 0;
    public static final int HANDVALUE_CHO = 1;
    public static final int HANDVALUE_PAA = 2;
    public static final Hand[] hand = {
            new Hand(HANDVALUE_GUU),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PAA)
    };


    public static final String name[] = {
            "石头","剪刀","布"
    };
    private int handValue;

    private Hand(int handValue) {
        this.handValue = handValue;
    }

    public static Hand getHand(int handValue) {
        return hand[handValue];
    }

    public boolean isStrongerThan(Hand hand) {
        return fight(hand) == 1;
    }

    public boolean isWeakerThan(Hand hand) {
        return fight(hand) == -1;
    }

    private int fight(Hand hand) {
        // 因为是单例，在这里可以放心使用 ==，直接比较二者地址
        if(this == hand){
            return 0;
        }else if((this.handValue +1)%3 == hand.handValue){
            return 1;
        }else {
            return -1;
        }
    }


    public String toString(){
        return name[handValue];
    }

}
