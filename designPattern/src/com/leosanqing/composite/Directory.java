package com.leosanqing.composite;

import java.util.ArrayList;

/**
 * @Author: leosanqing
 * @Date: 2019-09-24 08:24
 */
public class Directory extends Entry {
    private String name;
    private ArrayList<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;

        for (Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
    }

    public void add(Entry entry){
        directory.add(entry);

    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this.toString());
        for (Entry entry : directory) {
            entry.printList(prefix + "/" + name);
        }
    }
}
