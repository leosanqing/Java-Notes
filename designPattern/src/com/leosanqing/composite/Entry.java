package com.leosanqing.composite;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 10:33
 *
 * 将 File 和 Directory 看成是同一个东西
 *
 * Composite 模式是将 容器 和 内容 一致性，将多个对象结合在一起
 */
public abstract class Entry {
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
}
