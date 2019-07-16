package com.leosanqing.iterator.vectorImp;

import com.leosanqing.iterator.Book;
import com.leosanqing.iterator.Iterator;

public class BookShelfIteratorVec implements Iterator{
    private BookShelf bookShelfVec;
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
    public Object next() {
        Book book = bookShelfVec.getBookAt(index);
        index++;

        return book;
    }
}
