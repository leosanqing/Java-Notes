package com.leosanqing.interpreter;


/**
 * @Author: leosanqing
 * @Date: 2019-09-22 13:19
 */
public class ProgramNode extends Node {
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    public String toString() {
        return "[program " + commandListNode + "]";
    }


}
