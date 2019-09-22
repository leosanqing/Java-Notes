package com.leosanqing.command.drawer;

import com.leosanqing.command.command.MacroCommand;

import java.awt.*;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 11:03
 */
public class DrawCanvas extends Canvas implements Drawable {
    private Color color = Color.RED;
    private int radius = 6;
    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    public void paint(Graphics g) {
        history.execute();
    }


    @Override
    public void draw(int x, int y) {
        Graphics graphics = getGraphics();
        graphics.setColor(color);
        graphics.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
