package com.leosanqing.command.drawer;

import com.leosanqing.command.command.Command;

import java.awt.*;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 10:52
 */
public class DrawCommand implements Command {
    protected Drawable drawable;
    private Point position;

    public DrawCommand(Drawable drawable,Point position){
        this.drawable = drawable;
        this.position = position;
    }
    @Override
    public void execute() {
        drawable.draw(position.x,position.y);
    }
}
