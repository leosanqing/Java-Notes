package com.leosanqing.bridge;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 08:50
 */
public class Main {
    public static void main(String[] args) {
        Display display = new Display(new StringDisplay("leosanqing"));
        Display display1 = new CountDisplay(new StringDisplay("pipi"));
        CountDisplay countDisplay = new CountDisplay(new StringDisplay("hello world"));

        display.display();
        display1.display();

        countDisplay.display();
        countDisplay.multiDisplay(3);
    }
}
