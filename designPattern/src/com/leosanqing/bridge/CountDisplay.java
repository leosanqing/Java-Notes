package com.leosanqing.bridge;

/**
 * @Author: leosanqing
 * @Date: 2019-09-23 21:29
 */
public class CountDisplay extends Display {

    public CountDisplay(DisplayImpl display) {
        super(display);
    }


    public void multiDisplay(int count){
        open();
        for (int i = 0; i < count; i++) {
            print();
        }
        close();
    }


}
