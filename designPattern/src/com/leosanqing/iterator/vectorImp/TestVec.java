package com.leosanqing.iterator.vectorImp;

import com.leosanqing.iterator.ordinary.Book;
import com.leosanqing.iterator.ordinary.Iterator;

public class TestVec {
    public static void main(String[] args) {
        BookShelf bookShelf =new BookShelf(5);
        bookShelf.appendBook(new Book("head first Java"));
        bookShelf.appendBook(new Book("Design Pattern"));
        bookShelf.appendBook(new Book("Understanding the JVM"));
        Iterator iterator = bookShelf.iterator();
        while(iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }

    }
}
