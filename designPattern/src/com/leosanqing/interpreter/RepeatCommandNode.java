package com.leosanqing.interpreter;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 15:00
 */
public class RepeatCommandNode extends Node {
    private int number;
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }
}
