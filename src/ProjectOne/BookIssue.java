package ProjectOne;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BookIssue {

    private Book book;
    private Student student;
    private LocalDate issueDate;
    private LocalDate returnDate;

    // Constructor
    

    public BookIssue(Book book, Student student, LocalDate issueDate) {

        this.book = book;
        this.student = student;
        this.issueDate = issueDate;
    }

    // Getter Methods
    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    // Return Book
    public void returnBook(LocalDate returnDate) {

        this.returnDate = returnDate;
    }

    // Fine Calculation
    public long calculateFine() {

        if (returnDate == null) {
            return 0;
        }

        long days = ChronoUnit.DAYS.between(issueDate, returnDate);

        if (days > 7) {
            return (days - 7) * 10;
        }

        return 0;
    }

    // Display Issue Details
    @Override
    public String toString() {

        return "Student Name : " + student.getStudentName() +
               "\nBook Name    : " + book.getBookName() +
               "\nIssue Date   : " + issueDate +
               "\nReturn Date  : " +
               (returnDate == null ? "Not Returned" : returnDate) +
               "\nFine Amount  : ₹" + calculateFine();
    }
}