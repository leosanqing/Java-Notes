package com.leosanqing.decorator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 19:29
 */
public class FullBorder extends Border {

    protected FullBorder(Display display ) {
        super(display);
    }

    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int rows) {
        if (rows == 0) {//上边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (rows == display.getRows() + 1) {// 下边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {
            return "|" + display.getRowText(rows-1) + "|";
        }
    }

    private String makeLine(char c, int columns) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < columns; i++) {
            buffer.append(c);
        }
        return buffer.toString();
    }
}
