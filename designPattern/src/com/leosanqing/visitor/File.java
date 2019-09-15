package com.leosanqing.visitor;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 11:03
 */
public class File extends Entry {
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
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this.toString());
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
