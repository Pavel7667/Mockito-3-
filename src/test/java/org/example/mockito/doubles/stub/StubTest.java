package org.example.mockito.doubles.stub;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubTest {

    @Test
    public void demoStub() {
        BookRepo bookRepoStub = new BookRepoStub();
        BookService bookService = new BookService(bookRepoStub);
        List<Book> newBooks = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooks.size());
        assertEquals(450, newBooks.get(0).getPrice());
    }
}
