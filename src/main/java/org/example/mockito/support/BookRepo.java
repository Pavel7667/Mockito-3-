package org.example.mockito.support;

import java.util.List;

public interface BookRepo {


    List<Book> findNewBooks(int days);
}
