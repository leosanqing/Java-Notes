package com.leosanqing.decorator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-24 22:33
 */
public class FullBorder extends Border {
    protected FullBorder(Display display) {
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
        // 上边框
        if (rows == 0) {
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (rows == display.getRows() + 1) { // 下边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {
            return "|" + display.getRowText(rows-1) + "|";
        }
    }

    private String makeLine(char c, int columns) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < columns; i++) {
            buffer.append(c);
        }
        return buffer.toString();
    }
}
