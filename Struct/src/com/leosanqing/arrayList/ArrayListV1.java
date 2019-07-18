package com.leosanqing.arrayList;

import java.util.Arrays;

/**
 * ArrayList version 版本 不使用 泛型
 * <p>
 * 只有简单的增删改查功能，还有一些基础的
 */

public class ArrayListV1 {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private static Object[] EMPTY_ELEMENTDATA = {};

    private int modCoumnt = 0;

    /**
     * 为啥减去8，因为需要存储数组的长度，详细的可以看我的相关文章，里面有介绍
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    /**
     * 无参构造的时候创建的数组，为了和上面的 EMPTY_ELEMENTDATA区分
     * 以便了解我们第一次添加元素时，数组大小扩容成多大
     */
    private static Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    Object elementData[];

    public ArrayListV1(int initialCapacity) {
        if (initialCapacity >= 0) {
            elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("不合法的数组大小： "
                    + initialCapacity);
        }
    }

    public ArrayListV1(int size, Object[] elementData) {
        this.size = size;
        this.elementData = elementData;
    }

    public ArrayListV1() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(Object o) {
        return indexOf(0) >= 0;
    }

    /**
     * 根据对象来找出最早出现的索引
     * <p>
     * 如果没找到，返回 -1
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elementData[i].equals(o))
                    return i;
            }
        }
        return -1;
    }

    /**
     * 根据对象找出最后一次对象出现的索引
     * <p>
     * 如果没有匹配到，返回-1
     *
     * @param o
     * @return
     */
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size; i > 0; i--) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = size; i > 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    /**
     * 将列表转成数组
     *
     * @return
     */
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * 添加数据到数组的末尾
     *
     * @param o
     * @return
     */
    public boolean add(Object o) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = o;
        return true;
    }

    /**
     * 设置第 i个位置上的数据，并返回原来的值
     *
     * @param index
     * @param elem
     * @return
     */
    public Object set(int index, Object elem) {
        rangeCheck(index);
        Object oldValue = elementData[index];
        elementData[index] = elem;
        return oldValue;
    }



    private void ensureCapacityInternal(int miniCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, miniCapacity));
    }

    /**
     * 确认一下是否需要扩容
     * @param miniCapacity
     */
    private void ensureExplicitCapacity(int miniCapacity) {
        modCoumnt++;
        if (miniCapacity - elementData.length > 0)
            grow(miniCapacity);
    }

    /**
     *  计算一下需要扩容的值，这个只有在使用无参构造的时候才会触发
     * @param elementData
     * @param miniCapacity
     * @return
     */
    private static int calculateCapacity(Object[] elementData, int miniCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
            return Math.max(DEFAULT_CAPACITY, miniCapacity);
        return miniCapacity;
    }
    /**
     * 数组扩容，扩容成1.5倍
     *
     * @param miniCapacity
     */
    private void grow(int miniCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - miniCapacity < 0)
            newCapacity = miniCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(miniCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);

    }

    /**
     * 数组的长度非常大的时候的处理方式
     *
     * @param miniCapacity
     * @return
     */
    private int hugeCapacity(int miniCapacity) {
        if (miniCapacity < 0)
            throw new OutOfMemoryError();
        return (miniCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }



    /**
     * 根据索引查找元素，并返回
     *
     * @param index
     * @return
     */
    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    /**
     * 检查索引是否合法
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "输入的地址不合法:   index:" + index + "size:  " + size;
    }
}
