package com.leosanqing.chainofresponsibility;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 21:55
 */
public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);
        alice.setNextSupport(bob).setNextSupport(charlie).setNextSupport(diana)
                .setNextSupport(elmo).setNextSupport(fred);
        for (int i = 0; i < 500; i+= 33) {
            alice.support(new Trouble(i));
        }
    }
}
