package com.leosanqing.visitor;


import java.util.Iterator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-25 08:12
 */
public abstract class Entry implements Element{
    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public Iterator<Entry> iterator() throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}
