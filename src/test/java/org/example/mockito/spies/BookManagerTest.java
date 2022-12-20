package org.example.mockito.spies;

import org.example.mockito.spy.BookManager;
import org.example.mockito.spy.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest {

    @InjectMocks
    private BookManager bookManager;

    @Spy
    private BookService bookService;


    @Test
    public void testMockitoSpy() {
        BookService bookService = Mockito.spy(BookService.class);
        BookManager bookManager = new BookManager(bookService);
    }

}
