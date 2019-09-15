package com.leosanqing.visitor;

import com.leosanqing.composite.FileTreatmentException;

import java.util.Iterator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 10:33
 *
 * 将 File 和 Directory 看成是同一个东西
 */
public abstract class Entry implements Element{
    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

    public Iterator iterator() throws FileTreatmentException{
        throw new FileTreatmentException();
    }
}
