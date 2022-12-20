package org.example.mockito.spy;

public class BookManager {

    private BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }
}
