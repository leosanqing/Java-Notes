package bookSelf;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.addBook(new Book("Jobs"));
        bookShelf.addBook(new Book("原则"));
        bookShelf.addBook(new Book("深入理解Java虚拟机"));
        bookShelf.addBook(new Book("Spring技术内幕"));

        Iterator iterator = bookShelf.iterator();
        while (iterator.hashNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }

    }
}
