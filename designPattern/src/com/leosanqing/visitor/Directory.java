package com.leosanqing.visitor;

import com.leosanqing.factory.idcard.IDCard;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-25 08:23
 */
public class Directory extends Entry{
    private String name;

    private ArrayList<Entry> directory = new ArrayList<>();
    public Directory(String name) {
        this.name = name;
    }

    @Override
    public Entry add(Entry entry){
        directory.add(entry);
        return entry;
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


    public Iterator iterator(){
        return directory.iterator();
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}
