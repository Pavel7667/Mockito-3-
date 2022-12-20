package org.example.mockito.spy;

public class BookService {


    public Book findBook(String bookID) {
        return null;
    }

    public int getAppliedDiscount(Book book, int discountRate) {
        int price = book.getPrice();
        return price - (price * discountRate / 100);
    }
}
