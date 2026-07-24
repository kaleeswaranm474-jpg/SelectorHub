package ProjectOne;


public class Book {


    private int bookId;
    private String bookName;
    private String authorName;
    private int availableCopies;



    public Book(int bookId, String bookName, String authorName, int availableCopies) {


        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.availableCopies = availableCopies;


    }



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


    public void setAvailableCopies(int availableCopies) {

        this.availableCopies = availableCopies;

    }




    @Override
    public String toString() {


        return "\nBook ID          : " + bookId +
               "\nBook Name        : " + bookName +
               "\nAuthor Name      : " + authorName +
               "\nAvailable Copies : " + availableCopies;


    }


}