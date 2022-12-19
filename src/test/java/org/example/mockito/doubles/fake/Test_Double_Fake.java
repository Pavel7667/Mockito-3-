package org.example.mockito.doubles.fake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Double_Fake {

    @Test
    public void testFake() {
        FakeBookRepo fakeBookRepo = new FakeBookRepo();
        BookService bookService = new BookService(fakeBookRepo);

        bookService.addBook(new Book("1234", "Mockito3", 250, LocalDate.now()));
        bookService.addBook(new Book("1235", "jUnit5", 150, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBook());
    }
}
