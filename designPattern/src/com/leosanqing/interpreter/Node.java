package com.leosanqing.interpreter;


/**
 * @Author: leosanqing
 * @Date: 2019-09-22 13:18
 */
public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}
