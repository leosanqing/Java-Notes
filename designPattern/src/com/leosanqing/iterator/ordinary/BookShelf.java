package com.leosanqing.iterator.ordinary;

public class BookShelf implements Aggregate{
    public Book[] books;
    public int last = 0;
    public BookShelf(int maxsize){
         this.books = new Book[maxsize];
    }

    public void appendBook(Book book){
        this.books[last] = book;
        last++;
    }

    public Book getBookAt(int index){
        return this.books[index];
    }
    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }

    public int getLength() {
        return last;
    }
}
