package com.leosanqing.iterator.ordinary;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 17:07
 *
 * BookShelfIterator 实现了 Iterator接口。所以他必须实现接口中的两个方法
 *
 *
 */
public class BookShelfIterator<T> implements Iterator {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }
}
