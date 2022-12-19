package org.example.mockito.doubles.spy;

public class BookRepoSpy implements BookRepo {

    int saveCalled = 0;
    Book lastAddedBook = null;


    @Override
    public void save(Book book) {
        saveCalled++;
        lastAddedBook = book;
    }

    public int timesCalled() {
        return saveCalled;
    }

    public boolean calledBook(Book book) {
        return lastAddedBook.equals(book);
    }

}
