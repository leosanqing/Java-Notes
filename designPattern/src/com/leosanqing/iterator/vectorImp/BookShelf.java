package com.leosanqing.iterator.vectorImp;

import com.leosanqing.iterator.ordinary.Aggregate;
import com.leosanqing.iterator.ordinary.Iterator;

import java.util.Vector;

/**
 * 将数组改成 vector，其他不更改
 *
 * 代码仍然可以运行，并且使用泛型
 */
public class BookShelf<T> implements Aggregate {
    public Vector<T> books;

    public BookShelf(int maxsize) {
        books = new Vector<>(maxsize);
    }


    public T getBookAt(int index) {
        return books.elementAt(index);
    }

    public void appendBook(T book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIteratorVec(this);
    }
}
