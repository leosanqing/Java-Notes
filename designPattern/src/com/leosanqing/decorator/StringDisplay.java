package com.leosanqing.decorator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 12:41
 */
public class StringDisplay extends Display{
    private String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() {
        return string.getBytes().length;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int rows) {
        if(rows == 0){
            return string;
        }else{
            return null;
        }
    }
}
