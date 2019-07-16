package com.leosanqing.iterator;

import com.leosanqing.iterator.vectorImp.BookShelf;

public class Test {
    public static void main(String[] args) {

        BookShelf bookShelf = new BookShelf(5);
        bookShelf.appendBook(new Book("Jobs"));
        bookShelf.appendBook(new Book("Head First Java"));
        bookShelf.appendBook(new Book("Design Pattern"));

        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()){
            Book next = (Book) iterator.next();
            System.out.println(next.getName());
        }
    }
}
