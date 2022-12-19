package org.example.mockito.doubles.stub;

import java.util.List;

public interface BookRepo {


    List<Book> findNewBooks(int days);
}
