package com.leosanqing.iterator.vectorImp;

import com.leosanqing.iterator.ordinary.Iterator;

public class BookShelfIteratorVec<T> implements Iterator{
    private BookShelf<T> bookShelfVec;
    private int index;
    public BookShelfIteratorVec(BookShelf bookShelf){
        this.bookShelfVec = bookShelf ;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if(index < bookShelfVec.getLength()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public T next() {
        T book = bookShelfVec.getBookAt(index);
        index++;

        return book;
    }
}
