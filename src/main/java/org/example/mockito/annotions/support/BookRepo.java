package org.example.mockito.annotions.support;

import java.util.List;

public interface BookRepo {


    List<Book> findNewBooks(int days);
}
