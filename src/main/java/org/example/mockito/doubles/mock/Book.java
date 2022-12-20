package org.example.mockito.doubles.mock;

import java.time.LocalDate;

public class Book {
    private String bookID;
    private String title;
    private int price;
    private LocalDate publishDate;

    public Book(String bookID, String title, int price, LocalDate publishDate) {
        this.bookID = bookID;
        this.title = title;
        this.price = price;
        this.publishDate = publishDate;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
