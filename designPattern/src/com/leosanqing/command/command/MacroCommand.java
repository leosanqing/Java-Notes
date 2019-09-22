package com.leosanqing.command.command;

import java.util.Stack;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 10:36
 */
public class MacroCommand implements Command {
    private Stack<Command> commands = new Stack<>();

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public void append(Command command) {
        if (command != this)
            commands.push(command);
    }

    public void undo(){
        if(!commands.empty())
            commands.pop();
    }

    public void clear(){
        commands.clear();
    }
}
