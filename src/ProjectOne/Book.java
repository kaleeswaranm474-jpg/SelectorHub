package ProjectOne;

public class Book {

    private int bookId;
    private String bookName;
    private String authorName;
    private int availableCopies;

    // Constructor
    public Book(int bookId, String bookName, String authorName, int availableCopies) {

        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.availableCopies = availableCopies;
    }

    // Getter Methods
    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    // Setter Method
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    // Display Book Details
    @Override
    public String toString() {

        return "Book ID        : " + bookId +
               "\nBook Name      : " + bookName +
               "\nAuthor Name    : " + authorName +
               "\nAvailable Copy : " + availableCopies;
    }
}