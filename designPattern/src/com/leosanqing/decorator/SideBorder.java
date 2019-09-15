package com.leosanqing.decorator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 19:26
 */
public class SideBorder extends Border {
    private char c;

    protected SideBorder(Display display, char c) {
        super(display);
        this.c = c;
    }

    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int rows) {

        return c + display.getRowText(rows) + c;
    }
}
