package org.example.mockito.doubles.stub;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StubTest {

    @Test
    public void demoStub() {
        BookRepo bookRepoStub = new BookRepoStub();
        BookService bookService = new BookService(bookRepoStub);
        List<Book> newBooks = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooks.size());

    }

    @Test
    public void demoStubMock() {
        BookRepoStub bookRepoStub = mock(BookRepoStub.class);
        BookService bookService = new BookService(bookRepoStub);

        Book book1 = new Book("1234", "Mockito3", 500, LocalDate.now());
        Book book2 = new Book("1235", "jUnit5", 500, LocalDate.now());

        List<Book> newBooksTwo = new ArrayList<>();
        newBooksTwo.add(book1);
        newBooksTwo.add(book1);

        when(bookRepoStub.findNewBooks(7)).thenReturn(newBooksTwo);

        List<Book> newBookWithApplicationDiscount =
                bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksTwo.size());

    }
}
