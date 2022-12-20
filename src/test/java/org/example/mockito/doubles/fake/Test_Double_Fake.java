package org.example.mockito.doubles.fake;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Test_Double_Fake {

    @Test
    public void testFake() {
        FakeBookRepo fakeBookRepo = new FakeBookRepo();
        BookService bookService = new BookService(fakeBookRepo);

        bookService.addBook(new Book("1234", "Mockito3", 250, LocalDate.now()));
        bookService.addBook(new Book("1235", "jUnit5", 150, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBook());
    }

    @Test
    public void testFakeWithMockito() {
        BookRepo bookRepo = Mockito.mock(BookRepo.class);
        BookService bookService = new BookService(bookRepo);

        Book book1 = new Book("1234", "Mockito3", 250, LocalDate.now());
        Book book2 = new Book("1235", "jUnit5", 150, LocalDate.now());

        Collection<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book1);

        when(bookRepo.findAll()).thenReturn(books);

        assertEquals(2, bookService.findNumberOfBook());

    }
}
