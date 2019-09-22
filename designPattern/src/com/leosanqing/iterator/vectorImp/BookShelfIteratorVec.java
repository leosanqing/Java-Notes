package com.leosanqing.iterator.vectorImp;

import com.leosanqing.iterator.ordinary.Iterator;

public class BookShelfIteratorVec<T> implements Iterator<T> {
    private BookShelf<T> bookShelfVec;
    private int index;

    public BookShelfIteratorVec(BookShelf bookShelf) {
        this.bookShelfVec = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelfVec.getLength();
    }

    @Override
    public T next() {
        T book = bookShelfVec.getBookAt(index);
        index++;

        return book;
    }
}
