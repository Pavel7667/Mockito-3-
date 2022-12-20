package org.example.mockito.support;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestAnnotation {

    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepo bookRepo;


    @Test
    public void demoCreateTest() {

        Book book1 = new Book("1234", "Mockito3", 500, LocalDate.now());
        Book book2 = new Book("1235", "jUnit5", 500, LocalDate.now());

        List<Book> newBooksTwo = new ArrayList<>();
        newBooksTwo.add(book1);
        newBooksTwo.add(book1);

        when(bookRepo.findNewBooks(7)).thenReturn(newBooksTwo);

        List<Book> newBookWithApplicationDiscount =
                bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksTwo.size());
    }
}
