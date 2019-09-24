package com.leosanqing.composite;

/**
 * @Author: leosanqing
 * @Date: 2019-09-24 08:16
 */
public abstract class Entry {
    public abstract String getName();

    public abstract int getSize();

    public void add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }


    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    public String toString() {
        return getName() + "(" + getSize() + ")";
    }

}
