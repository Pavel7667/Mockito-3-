package org.example.mockito.doubles.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepoStub implements BookRepo {
    @Override
    public List<Book> findNewBooks(int days) {
        List<Book> newBooks = new ArrayList<>();
        Book book1 = new Book("1234", "Mockito3", 250, LocalDate.now());
        Book book2 = new Book("1235", "jUnit5", 150, LocalDate.now());

        newBooks.add(book1);
        newBooks.add(book2);

        return newBooks;
    }
}
