package org.example.mockito.stubbing;

import java.util.List;

public class BookService {

    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days) {
        List<Book> newBooks = bookRepo.findNewBooks(days);
        // 500 apply 10 % discount = 450
        for (Book book : newBooks) {
            int price = book.getPrice();
            int newPrice = (discountRate * price / 10);
            book.setPrice(newPrice);
        }
        return newBooks;
    }

    public int totalCost(List<String> bookID) {
        int total = 0;
        for (String eOfBook : bookID) {
            Book book = bookRepo.findBookByBookId(eOfBook);
            total = total + book.getPrice();
        }
        return total;
    }

    public void addBook(Book book) {
        bookRepo.save(book);
    }
}
