package com.leosanqing.iterator.vectorImp;

import com.leosanqing.iterator.Aggregate;
import com.leosanqing.iterator.Book;
import com.leosanqing.iterator.Iterator;

import java.util.Vector;

/**
 * 将数组改成 vector，其他不更改，代码仍然可以运行
 */
public class BookShelf implements Aggregate {
    public Vector<Book> books;
    private int last = 0;

    public BookShelf(int maxsize){
        books = new Vector<>(maxsize);
    }


    public Book getBookAt(int index){
        return books.elementAt(index);
    }

    public void appendBook(Book book){
        books.add(last,book);
        last++;
    }

    public int getLength(){
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIteratorVec(this);
    }
}
