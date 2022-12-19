package org.example.mockito.doubles.spy;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpyTest {

    @Test
    public void demoSpy() {
        BookRepoSpy bookRepoSpy = new BookRepoSpy();
        BookService bookService = new BookService(bookRepoSpy);
        Book book1 = new Book("1234", "Mockito3", 250, LocalDate.now());
        Book book2 = new Book("1235", "jUnit5", 150, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        assertEquals(2, bookRepoSpy.timesCalled());
        assertTrue(bookRepoSpy.calledBook(book2));
    }
}
