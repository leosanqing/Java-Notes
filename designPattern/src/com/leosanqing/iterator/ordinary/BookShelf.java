package com.leosanqing.iterator.ordinary;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 16:57
 *
 *
 * BookShelf 类 实现了 Aggregate 接口。
 *
 * Aggregate 接口又使用了 Iterator 接口
 */
public class BookShelf<T> implements Aggregate {
    private Book[] books;

    private int maxSize = 0;
    private int last = 0;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
        this.maxSize = maxSize;
    }

    public void append(Book book) {
        if (last > maxSize) {
            throw new IndexOutOfBoundsException("超过了数组的范围");
        }
        books[last] = book;
        last++;
    }

    public Book getBookAt(int index) {
        if (index >= maxSize - 1) {
            throw new IndexOutOfBoundsException("超过了数组范围: [范围]:"
                    + maxSize + "[index]:" + index);
        }
        return books[index];
    }

    public int getLength(){
        return last;
    }

    // 因为 BookShelfIterator 是 Iterator的具体实现
    // 所以 可以用Iterator 直接接收 返回的BookShelfIterator类型
    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
