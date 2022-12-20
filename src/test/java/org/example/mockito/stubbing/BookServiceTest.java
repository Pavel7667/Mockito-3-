package org.example.mockito.stubbing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepo bookRepo;

    @Test
    public void testCalculateTotalCostBook() {
        List<String> booksIds = new ArrayList<>();
        booksIds.add("1234");
        booksIds.add("1235");

        Book book1 = new Book("1234", "Mockito3", 500, LocalDate.now());
        Book book2 = new Book("1235", "jUnit5", 500, LocalDate.now());

        doReturn(book1).when(bookRepo).findBookByBookId("1234");
        doReturn(book2).when(bookRepo).findBookByBookId("1235");

        int cost = bookService.totalCost(booksIds);
        assertEquals(1000, cost);
    }

    @Test
    public void testSaveVoid() {
        Book book1 = new Book(null, "Mockito3", 500, LocalDate.now());
        doNothing().when(bookRepo).save(book1);
        bookService.addBook(book1);
    }
}
