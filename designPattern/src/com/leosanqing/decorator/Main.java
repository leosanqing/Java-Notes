package com.leosanqing.decorator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 19:38
 */
public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("leosanqing");
        Display b2 = new SideBorder(b1,'#');
        Display b3 = new FullBorder(b2);

        b1.show();
        b2.show();
        b3.show();

        new SideBorder(
                new FullBorder(
                        new FullBorder(
                                new SideBorder(
                                        new FullBorder(
                                                new StringDisplay("pipi")
                                        ),'*'
                                )
                        )
                ),'/'
        ).show();
    }
}
