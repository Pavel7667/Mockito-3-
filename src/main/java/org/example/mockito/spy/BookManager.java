package org.example.mockito.spy;

public class BookManager {

    private BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    public int applyDiscountOnBook(String bookID, int discountRate) {
        Book book = bookService.findBook(bookID); // to MOCK
        return bookService.getAppliedDiscount(book, discountRate); // need actual Call
    }
}
