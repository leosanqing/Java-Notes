package com.leosanqing.template;

public class Test {
    public static void main(String[] args) {
        AbstractDisplay charDisplay = new CharDisplay('H');
        AbstractDisplay stringDisplay = new StringDisplay("hello world");
        stringDisplay.display();
        charDisplay.display();
    }
}
