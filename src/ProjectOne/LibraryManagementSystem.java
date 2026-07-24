package ProjectOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.Scanner;

public class LibraryManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    static HashMap<String, BookIssue> issuedBooks = new HashMap<>();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Add Student");
            System.out.println("5. View Students");
            System.out.println("6. Search Student");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. View Issued Books");
            System.out.println("10. Exit");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:
                addBook();
                break;

            case 2:
                viewBooks();
                break;

            case 3:
                searchBook();
                break;

            case 4:
                addStudent();
                break;

            case 5:
                viewStudents();
                break;

            case 6:
                searchStudent();
                break;

            case 7:
                issueBook();
                break;

            case 8:
                returnBook();
                break;

            case 9:
                viewIssuedBooks();
                break;

            case 10:
                System.out.println("Thank You...");
                break;

            default:
                System.out.println("Invalid Choice...");
            }

        } while (choice != 10);

    }

    // ================= ADD BOOK =================

    static void addBook() {

        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name : ");
        String author = sc.nextLine();

        System.out.print("Enter Available Copies : ");
        int copies = sc.nextInt();

        Book book = new Book(id, name, author, copies);

        books.add(book);

        System.out.println("Book Added Successfully.");

    }

    // ================= VIEW BOOKS =================

    static void viewBooks() {

        if (books.isEmpty()) {

            System.out.println("No Books Available.");
            return;
        }

        System.out.println("\n========= BOOK LIST =========");

        for (Book book : books) {

            System.out.println(book);
            System.out.println("----------------------------");
        }

    }

    // ================= SEARCH BOOK =================

    static void searchBook() {

        if (books.isEmpty()) {

            System.out.println("No Books Available.");
            return;
        }

        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();

        boolean found = false;

        for (Book book : books) {

            if (book.getBookId() == id) {

                System.out.println(book);
                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println("Book Not Found.");
        }

    }

    // ================= ADD STUDENT =================

    static void addStudent() {

        System.out.print("Enter Student ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Department : ");
        String dept = sc.nextLine();

        Student student = new Student(id, name, dept);

        students.add(student);

        System.out.println("Student Added Successfully.");

    }
    
    // ================= VIEW STUDENTS =================

    static void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No Students Available.");
            return;
        }

        System.out.println("\n========= STUDENT LIST =========");

        for (Student student : students) {

            System.out.println(student);
            System.out.println("----------------------------");
        }

    }

    // ================= SEARCH STUDENT =================

    static void searchStudent() {

        if (students.isEmpty()) {

            System.out.println("No Students Available.");
            return;
        }

        System.out.print("Enter Student ID : ");
        int id = sc.nextInt();

        boolean found = false;

        for (Student student : students) {

            if (student.getStudentId() == id) {

                System.out.println(student);
                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println("Student Not Found.");
        }

    }

    // ================= ISSUE BOOK =================

    static void issueBook() {

        if (books.isEmpty()) {

            System.out.println("No Books Available.");
            return;
        }

        if (students.isEmpty()) {

            System.out.println("No Students Available.");
            return;
        }

        System.out.print("Enter Student ID : ");
        int studentId = sc.nextInt();

        Student student = null;

        for (Student s : students) {

            if (s.getStudentId() == studentId) {

                student = s;
                break;
            }
        }

        if (student == null) {

            System.out.println("Student Not Found.");
            return;
        }

        System.out.print("Enter Book ID : ");
        int bookId = sc.nextInt();

        Book book = null;

        for (Book b : books) {

            if (b.getBookId() == bookId) {

                book = b;
                break;
            }
        }

        if (book == null) {

            System.out.println("Book Not Found.");
            return;
        }

        if (book.getAvailableCopies() <= 0) {

            System.out.println("Book Not Available.");
            return;
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        sc.nextLine();

        System.out.print("Enter Issue Date (yyyy-MM-dd) : ");
        String issue = sc.nextLine();

        LocalDate issueDate = LocalDate.parse(issue);

        BookIssue bookIssue = new BookIssue(book, student, issueDate);

        issuedBooks.put(student.getStudentName(), bookIssue);

        System.out.println("Book Issued Successfully.");

    }

    // ================= RETURN BOOK =================

    static void returnBook() {

        if (issuedBooks.isEmpty()) {

            System.out.println("No Issued Books.");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Student Name : ");
        String name = sc.nextLine();

        BookIssue issue = issuedBooks.get(name);

        if (issue == null) {

            System.out.println("Student Record Not Found.");
            return;
        }

        System.out.print("Enter Return Date (yyyy-MM-dd) : ");
        String ret = sc.nextLine();

        LocalDate returnDate = LocalDate.parse(ret);

        issue.returnBook(returnDate);

        Book book = issue.getBook();

        book.setAvailableCopies(book.getAvailableCopies() + 1);

        System.out.println("Book Returned Successfully.");
        System.out.println("Fine Amount : ₹" + issue.calculateFine());

        issuedBooks.remove(name);

    }

    // ================= VIEW ISSUED BOOKS =================

    static void viewIssuedBooks() {

        if (issuedBooks.isEmpty()) {

            System.out.println("No Books Issued.");
            return;
        }

        System.out.println("\n========= ISSUED BOOKS =========");

        for (BookIssue issue : issuedBooks.values()) {

            System.out.println(issue);
            System.out.println("----------------------------");
        }

    }

}