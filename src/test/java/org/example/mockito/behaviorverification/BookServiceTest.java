package org.example.mockito.behaviorverification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepo bookRepo;

    @Test
    public void testAddBook() {
        Book book = new Book(null, "Mock3", 550, LocalDate.now());
        bookService.addBook(book);
        verify(bookRepo).save(book);
    }
}