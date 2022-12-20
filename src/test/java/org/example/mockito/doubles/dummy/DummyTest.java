package org.example.mockito.doubles.dummy;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DummyTest {

    @Test
    public void testFake() {
        BookRepo bookRepo = new FakeBookRepo();
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepo, emailService);

        bookService.addBook(new Book("1234", "Mockito3", 250, LocalDate.now()));
        bookService.addBook(new Book("1235", "jUnit5", 150, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBook());
    }

    @Test
    public void testFakeMockito() {
        BookRepo bookRepo = mock(BookRepo.class);
        EmailService emailService = mock(EmailService.class);
        BookService bookService = new BookService(bookRepo, emailService);

        Book book1 = new Book("1234", "Mockito3", 250, LocalDate.now());
        Book book2 = new Book("1235", "jUnit5", 150, LocalDate.now());

        Collection<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book1);

        when(bookRepo.findAll()).thenReturn(books);

        assertEquals(2, bookService.findNumberOfBook());
    }

}
