package com.leosanqing.iterator;

public class BookShelf implements Aggregate{
    public Book[] books;
    public int last = 0;

    public void appendBook(Book book){
        this.books[last] = book;
        last++;
    }

    public Book getBookAt(int index){
        return this.books[index];
    }
    @Override
    public Iterator iterator() {
        return null;
    }

    public int getLength() {
        return last;
    }
}
