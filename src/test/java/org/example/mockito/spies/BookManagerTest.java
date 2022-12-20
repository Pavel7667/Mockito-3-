package org.example.mockito.spies;

import org.example.mockito.spy.Book;
import org.example.mockito.spy.BookManager;
import org.example.mockito.spy.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest {

    @InjectMocks
    private BookManager bookManager;

    @Spy
    private BookService bookService;

    @Test
    public void testMockitoSpy() {
        Book book1 = new Book("1234", "Mockito3", 500, LocalDate.now());
        Mockito.doReturn(book1).when(bookService).findBook("1234");
        int discount = bookManager.applyDiscountOnBook("1234", 10);
        assertEquals(450, discount);
    }
}
