package org.example.mockito.doubles.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepo implements BookRepo {

    //Memory fake DB
    Map<String, Book> bookStore = new HashMap<>();

    @Override
    public void save(Book book) {
        bookStore.put(book.getBookID(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
