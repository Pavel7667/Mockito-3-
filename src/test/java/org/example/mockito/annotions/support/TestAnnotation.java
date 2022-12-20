package org.example.mockito.annotions.support;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class TestAnnotation {

    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepo bookRepo;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

//    @Before
//    public void beforeEach(){
//        MockitoAnnotations.initMocks(this);
//    }


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
