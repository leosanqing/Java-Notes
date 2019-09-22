package com.leosanqing.flyweight;

/**
 * @Author: leosanqing
 * @Date: 2019-09-21 10:41
 */
public class BigString {
    private BigChar[] bigChars;

    public BigString(String string){
        bigChars = new BigChar[string.length()];

        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < string.length(); i++) {
            bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    public void print(){
        for (int i = 0; i < bigChars.length; i++) {
            bigChars[i].print();
        }
    }
}
