package com.leosanqing.iterator.ordinary;



public class Test {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(5);
        bookShelf.append(new Book("Jobs"));
        bookShelf.append(new Book("Head First Java"));
        bookShelf.append(new Book("Design Pattern"));

        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()){
            Book next = (Book)iterator.next();
            System.out.println(next.getName());
        }
    }
}
