package com.leosanqing.visitor;

/**
 * @Author: leosanqing
 * @Date: 2019-09-25 08:15
 */
public class File extends Entry{
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}
