package org.example.mockito.behaviorverification;

public class BookService {

    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addBook(Book book) {
        if (book.getPrice() <= 500) {
            return;
        }
        bookRepo.save(book);
    }
}
