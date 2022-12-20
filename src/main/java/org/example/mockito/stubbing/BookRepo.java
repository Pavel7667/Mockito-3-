package org.example.mockito.stubbing;

import java.util.List;

public interface BookRepo {
    List<Book> findNewBooks(int days);

    Book findBookByBookId(String bookID);

    void save(Book book1);
}
