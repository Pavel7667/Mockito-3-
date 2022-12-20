package org.example.mockito.doubles.spy;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SpyTest {

    @Test
    public void demoMockSpy() {
        BookRepo bookRepoMock = spy(BookRepo.class);
        BookService bookService = new BookService(bookRepoMock);
        Book book1 = new Book("1234", "Mockito3", 500, LocalDate.now());
        Book book2 = new Book("1235", "jUnit5", 200, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        verify(bookRepoMock, times(1)).save(book2);
        verify(bookRepoMock, times(0)).save(book1);

    }
}
