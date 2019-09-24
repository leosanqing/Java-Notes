package com.leosanqing.decorator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-24 22:13
 */
public class SideBorder extends Border {
    private char borderChar;

    protected SideBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
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
        return borderChar + display.getRowText(rows) + borderChar;
    }
}
