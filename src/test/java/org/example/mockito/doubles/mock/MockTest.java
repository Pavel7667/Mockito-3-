package org.example.mockito.doubles.mock;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MockTest {

    @Test
    public void demoSpy() {
        BookRepoMock bookRepoMock = new BookRepoMock();
        BookService bookService = new BookService(bookRepoMock);
        Book book1 = new Book("1234", "Mockito3", 500, LocalDate.now());
        Book book2 = new Book("1235", "jUnit5", 200, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        bookRepoMock.verify(book2, 1);


    }
}
