package org.example.mockito.doubles.dummy;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
