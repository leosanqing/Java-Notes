package com.leosanqing.interpreter;

import java.util.ArrayList;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 14:45
 */
public class CommandListNode extends Node {
    private ArrayList<Node> list = new ArrayList<>();
    @Override
    public void parse(Context context) throws ParseException {
        while (true){
            if(context.currentToken() == null){
                throw new ParseException("Missing 'end'");
            }else if(context.currentToken().equals("end")){
                context.skipToken("end");
                break;
            }else{
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    public String toString(){
        return list.toString();
    }
}
