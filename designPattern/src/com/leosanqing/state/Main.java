package com.leosanqing.state;

/**
 * @Author: leosanqing
 * @Date: 2019-09-19 22:31
 */
public class Main {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Sample");
        while (true){
            for (int i = 0; i < 24; i++) {
                frame.setClock(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
