package org.example.mockito.doubles.dummy;

public class BookService {

    private BookRepo bookRepo;
    private EmailService emailService;

    public BookService(BookRepo bookRepo, EmailService emailService) {
        this.bookRepo = bookRepo;
        this.emailService = emailService;
    }

    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public int findNumberOfBook() {
        return bookRepo.findAll().size();
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
}
