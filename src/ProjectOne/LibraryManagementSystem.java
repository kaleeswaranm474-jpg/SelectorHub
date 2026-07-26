package ProjectOne;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LibraryManagementSystem {

    static Scanner sc = new Scanner(System.in);

    // Shared Data
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();

    // One student can issue maximum 3 books
    static ArrayList<BookIssue> issuedBooks = new ArrayList<>();

    // History of returned books (kept for Fine Calculation)
    static ArrayList<BookIssue> returnedBooks = new ArrayList<>();

    // =================================
    // SAFE INTEGER READER (crash-proof)
    // =================================

    static int readInt() {

        if (sc.hasNextInt()) {

            return sc.nextInt();

        }

        sc.next();   // discard the invalid (non-numeric) token
        return -1;   // sentinel value; -1 never matches a valid menu/ID

    }

    public static void main(String[] args) {

        addDefaultBooks();
        addDefaultStudents();
        addDefaultReturnedRecords();

        int choice;

        do {

            System.out.println("\n=====================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=====================================");
            System.out.println("1. Librarian");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Enter Choice : ");

            choice = readInt();

            switch (choice) {

            case 1:

                if (librarianLogin()) {

                    librarianMenu();

                }

                break;

            case 2:

                studentMenu();

                break;

            case 3:

                System.out.println("Thank You...");
                break;

            default:

                System.out.println("Invalid Choice");

            }

        } while (choice != 3);

    }

    // =================================
    // DEFAULT BOOKS
    // =================================

    static void addDefaultBooks() {

        books.add(new Book(101, "Java Programming", "James Gosling", 5));
        books.add(new Book(102, "Python Basics", "Guido", 4));
        books.add(new Book(103, "SQL Fundamentals", "Oracle", 5));
        books.add(new Book(104, "Database Management", "C.J.Date", 3));
        books.add(new Book(105, "HTML and CSS", "Jon Duckett", 4));
        books.add(new Book(106, "JavaScript", "Brendan Eich", 5));
        books.add(new Book(107, "Spring Boot", "Pivotal", 3));
        books.add(new Book(108, "Data Structure", "Mark Allen", 4));
        books.add(new Book(109, "Operating System", "Galvin", 3));
        books.add(new Book(110, "Computer Network", "Tanenbaum", 4));
        books.add(new Book(111, "Software Engineering", "Pressman", 3));
        books.add(new Book(112, "Artificial Intelligence", "Russell", 2));
        books.add(new Book(113, "Machine Learning", "Tom Mitchell", 3));
        books.add(new Book(114, "Cyber Security", "William", 4));
        books.add(new Book(115, "Cloud Computing", "Rajkumar", 3));

    }

    // =================================
    // DEFAULT STUDENTS
    // =================================

    static void addDefaultStudents() {

        students.add(new Student(1, "Arun", "CSE", "123"));
        students.add(new Student(2, "Kumar", "IT", "456"));
        students.add(new Student(3, "Vishnu", "ECE", "789"));

    }

    // =================================
    // DEFAULT RETURNED RECORDS (SAMPLE DATA FOR FINE CALCULATION DEMO)
    // =================================

    static void addDefaultReturnedRecords() {

        // Arun issued "Java Programming" and returned it late
        BookIssue issue1 = new BookIssue(books.get(0), students.get(0), LocalDate.of(2026, 7, 1));
        issue1.returnBook(LocalDate.of(2026, 7, 20));
        returnedBooks.add(issue1);

        // Kumar issued "Python Basics" and returned it late
        BookIssue issue2 = new BookIssue(books.get(1), students.get(1), LocalDate.of(2026, 7, 5));
        issue2.returnBook(LocalDate.of(2026, 7, 25));
        returnedBooks.add(issue2);

    }

    // =================================
    // LIBRARIAN LOGIN
    // =================================

    static boolean librarianLogin() {

        System.out.print("Enter Librarian ID : ");
        String id = sc.next();

        System.out.print("Enter Password : ");
        String password = sc.next();

        if (id.equals("Vishnu") && password.equals("Vishnu123")) {

            System.out.println("Login Successful");
            return true;

        }

        System.out.println("Invalid Login");
        return false;

    }
    
 // =================================
 // LIBRARIAN MENU
 // =================================

 static void librarianMenu() {

     int choice;

     do {

         System.out.println("\n========== LIBRARIAN MENU ==========");

         System.out.println("1. Add Book");
         System.out.println("2. Remove Book");
         System.out.println("3. View All Books");
         System.out.println("4. Search Book");
         System.out.println("5. View All Students");
         System.out.println("6. Search Student");
         System.out.println("7. View Issued Books");
         System.out.println("8. Fine Calculation");
         System.out.println("9. Manage Records");
         System.out.println("10. Logout");

         System.out.print("Enter Choice : ");
         choice = readInt();

         switch(choice) {

         case 1:
             addBook();
             break;

         case 2:
             removeBook();
             break;

         case 3:
             viewBooks();
             break;

         case 4:
             searchBook();
             break;

         case 5:
             viewStudents();
             break;

         case 6:
             searchStudent();
             break;

         case 7:
             viewIssuedBooks();
             break;

         case 8:
             calculateFine();
             break;

         case 9:
             manageRecords();
             break;

         case 10:
             System.out.println("Logout Successfully");
             break;

         default:
             System.out.println("Invalid Choice");
         }

     } while(choice != 10);

 }
 
//=================================
//ADD BOOK
//=================================

static void addBook() {

  System.out.print("Enter Book ID : ");

  if (!sc.hasNextInt()) {

      System.out.println("Invalid Book ID (must be a number)");
      sc.next();
      return;

  }

  int id = sc.nextInt();

  for (Book b : books) {

      if (b.getBookId() == id) {

          System.out.println("Book ID Already Exists");
          return;

      }

  }

  sc.nextLine();

  System.out.print("Enter Book Name : ");
  String name = sc.nextLine();

  System.out.print("Enter Author Name : ");
  String author = sc.nextLine();

  System.out.print("Enter Available Copies : ");

  if (!sc.hasNextInt()) {

      System.out.println("Invalid Copies (must be a number)");
      sc.next();
      return;

  }

  int copies = sc.nextInt();

  books.add(new Book(id, name, author, copies));

  System.out.println("Book Added Successfully");

}

//=================================
//REMOVE BOOK
//=================================

static void removeBook() {

 System.out.print("Enter Book ID : ");

 if (!sc.hasNextInt()) {

     System.out.println("Invalid Book ID (must be a number)");
     sc.next();
     return;

 }

 int id = sc.nextInt();

 for (int i = 0; i < books.size(); i++) {

     if (books.get(i).getBookId() == id) {

         books.remove(i);

         System.out.println("Book Removed Successfully");
         return;

     }

 }

 System.out.println("Book Not Found");

}

//=================================
//VIEW ALL BOOKS
//=================================

static void viewBooks() {

 if (books.isEmpty()) {

     System.out.println("No Books Available");
     return;

 }

 System.out.println("\n========== BOOK LIST ==========");

 for (Book b : books) {

     System.out.println(b);
     System.out.println("----------------------------");

 }

}

//=================================
//SEARCH BOOK
//=================================

static void searchBook() {

 System.out.print("Enter Book ID : ");

 if (!sc.hasNextInt()) {

     System.out.println("Invalid Book ID (must be a number)");
     sc.next();
     return;

 }

 int id = sc.nextInt();

 for (Book b : books) {

     if (b.getBookId() == id) {

         System.out.println(b);
         return;

     }

 }

 System.out.println("Book Not Found");

}

//=================================
//VIEW ALL STUDENTS
//=================================

static void viewStudents() {

 if (students.isEmpty()) {

     System.out.println("No Students Available");
     return;

 }

 System.out.println("\n========== STUDENT LIST ==========");

 for (Student s : students) {

     System.out.println(s);
     System.out.println("----------------------------");

 }

}

//=================================
//SEARCH STUDENT
//=================================

static void searchStudent() {

 System.out.print("Enter Student ID : ");

 if (!sc.hasNextInt()) {

     System.out.println("Invalid Student ID (must be a number)");
     sc.next();
     return;

 }

 int id = sc.nextInt();

 for (Student s : students) {

     if (s.getStudentId() == id) {

         System.out.println(s);
         return;

     }

 }

 System.out.println("Student Not Found");

}

//=================================
//ISSUE BOOK
//=================================

static void issueBook(Student student) {

 int count = 0;

 for (BookIssue issue : issuedBooks) {

     if (issue.getStudent().getStudentId() == student.getStudentId()) {

         count++;

     }

 }

 if (count >= 3) {

     System.out.println("Maximum 3 Books Allowed.");
     return;

 }

 System.out.print("Enter Book ID : ");

 if (!sc.hasNextInt()) {

     System.out.println("Invalid Book ID (must be a number)");
     sc.next();
     return;

 }

 int id = sc.nextInt();

 Book book = null;

 for (Book b : books) {

     if (b.getBookId() == id) {

         book = b;
         break;

     }

 }

 if (book == null) {

     System.out.println("Book Not Found");
     return;

 }

 if (book.getAvailableCopies() <= 0) {

     System.out.println("Book Not Available");
     return;

 }

 for (BookIssue issue : issuedBooks) {

     if (issue.getStudent().getStudentId() == student.getStudentId()
             &&
         issue.getBook().getBookId() == id) {

         System.out.println("You already issued this Book.");
         return;

     }

 }

 sc.nextLine();

 LocalDate issueDate = null;

 while (issueDate == null) {

     System.out.print("Enter Issue Date (yyyy-MM-dd) : ");

     String dateInput = sc.nextLine();

     try {

         issueDate = LocalDate.parse(dateInput);

     } catch (DateTimeParseException e) {

         System.out.println("Invalid Date Format. Please Use yyyy-MM-dd (e.g. 2026-07-26)");

     }

 }

 BookIssue issue = new BookIssue(book, student, issueDate);

 issuedBooks.add(issue);

 book.setAvailableCopies(book.getAvailableCopies() - 1);

 System.out.println("Book Issued Successfully");

}

//=================================
//RETURN BOOK
//=================================

static void returnBook(Student student) {

 System.out.print("Enter Book ID : ");

 if (!sc.hasNextInt()) {

     System.out.println("Invalid Book ID (must be a number)");
     sc.next();
     return;

 }

 int id = sc.nextInt();

 BookIssue issue = null;

 for (BookIssue b : issuedBooks) {

     if (b.getStudent().getStudentId() == student.getStudentId()
             &&
         b.getBook().getBookId() == id) {

         issue = b;
         break;

     }

 }

 if (issue == null) {

     System.out.println("Book Issue Record Not Found");
     return;

 }

 sc.nextLine();

 LocalDate returnDate = null;

 while (returnDate == null) {

     System.out.print("Enter Return Date (yyyy-MM-dd) : ");

     String dateInput = sc.nextLine();

     try {

         returnDate = LocalDate.parse(dateInput);

     } catch (DateTimeParseException e) {

         System.out.println("Invalid Date Format. Please Use yyyy-MM-dd (e.g. 2026-07-26)");

     }

 }

 issue.returnBook(returnDate);

 issue.getBook().setAvailableCopies(
         issue.getBook().getAvailableCopies() + 1);

 System.out.println("Book Returned Successfully");
 System.out.println("Fine Amount : ₹" + issue.calculateFine());

 issuedBooks.remove(issue);
 returnedBooks.add(issue);

}

//=================================
//VIEW MY ISSUED BOOKS
//=================================

static void viewMyIssuedBooks() {

 Student student = studentLogin();

 if (student == null) {

     System.out.println("Invalid Student ID or Password");
     return;

 }

 boolean found = false;

 System.out.println("\n========== MY ISSUED BOOKS ==========");

 for (BookIssue issue : issuedBooks) {

     if (issue.getStudent().getStudentId() == student.getStudentId()) {

         System.out.println(issue);
         System.out.println("--------------------------------");

         found = true;

     }

 }

 if (!found) {

     System.out.println("No Issued Books");

 }

}

//=================================
//VIEW ISSUED BOOKS
//=================================

static void viewIssuedBooks() {

 if (issuedBooks.isEmpty()) {

     System.out.println("No Books Issued");
     return;

 }

 System.out.println("\n========== ISSUED BOOKS ==========");

 for (BookIssue issue : issuedBooks) {

     System.out.println(issue);
     System.out.println("--------------------------------");

 }

}

//=================================
//FINE CALCULATION
//=================================

static void calculateFine() {

 if (returnedBooks.isEmpty()) {

     System.out.println("No Returned Books");
     return;

 }

 System.out.println("\n========== FINE DETAILS ==========");

 for (BookIssue issue : returnedBooks) {

     System.out.println("Student Name : " + issue.getStudent().getStudentName());
     System.out.println("Book Name    : " + issue.getBook().getBookName());
     System.out.println("Issue Date   : " + issue.getIssueDate());
     System.out.println("Return Date  : " + issue.getReturnDate());
     System.out.println("Fine Amount  : ₹" + issue.calculateFine());

     System.out.println("--------------------------------");

 }

}

//=================================
//MANAGE RECORDS
//=================================

static void manageRecords() {

 int choice;

 do {

     System.out.println("\n========== MANAGE RECORDS ==========");
     System.out.println("1. Total Books");
     System.out.println("2. Total Students");
     System.out.println("3. Total Issued Books");
     System.out.println("4. Back");

     System.out.print("Enter Choice : ");
     choice = readInt();

     switch (choice) {

     case 1:
         System.out.println("Total Books : " + books.size());
         break;

     case 2:
         System.out.println("Total Students : " + students.size());
         break;

     case 3:
         System.out.println("Currently Issued Books : " + issuedBooks.size());
         break;

     case 4:
         break;

     default:
         System.out.println("Invalid Choice");

     }

 } while (choice != 4);

}



 // =================================
 // STUDENT MENU
 // =================================

 static void studentMenu() {

     int choice;

     do {

         System.out.println("\n=========== STUDENT MENU ===========");

         System.out.println("1. View All Books");
         System.out.println("2. Search Book");
         System.out.println("3. Register(issue and return book)");
         System.out.println("4. Logout");

         System.out.print("Enter Choice : ");
         choice = readInt();

         switch(choice) {

         case 1:
             viewBooks();
             break;

         case 2:
             searchBook();
             break;

         case 3:
             registerMenu();
             break;

         case 4:
             System.out.println("Logout Successfully");
             break;

         default:
             System.out.println("Invalid Choice");
         }

     } while(choice != 4);

 }

 // =================================
 // REGISTER MENU
 // =================================

 static void registerMenu() {

     System.out.println("\n=========== REGISTER MENU ===========");
     System.out.println("1. Register Student");
     System.out.println("2. Already Registered (Issue / Return Book)");

     System.out.print("Enter Choice : ");
     int choice = readInt();

     if (choice == 1) {

         registerStudent();

         issueReturnMenu();

     } else if (choice == 2) {

         issueReturnMenu();

     } else {

         System.out.println("Invalid Choice");

     }

 }

 // =================================
 // ISSUE AND RETURN BOOK MENU
 // =================================

 static void issueReturnMenu() {

     int choice;

     do {

         System.out.println("\n=========== ISSUE AND RETURN BOOK ===========");
         System.out.println("1. View My Issued Books");
         System.out.println("2. Issue Book");
         System.out.println("3. Return Book");
         System.out.println("4. Back");

         System.out.print("Enter Choice : ");
         choice = readInt();

         switch(choice) {

         case 1:
             viewMyIssuedBooks();
             break;

         case 2:
             loginForIssueBook();
             break;

         case 3:
             loginForReturnBook();
             break;

         case 4:
             break;

         default:
             System.out.println("Invalid Choice");
         }

     } while(choice != 4);

 }
 
//=================================
//REGISTER STUDENT
//=================================

static void registerStudent() {

  sc.nextLine();

  System.out.print("Enter Student Name : ");
  String name = sc.nextLine();

  System.out.print("Enter Department : ");
  String dept = sc.nextLine();

  System.out.print("Create Password : ");
  String password = sc.next();

  for(Student s : students) {

      if(s.getStudentName().equalsIgnoreCase(name)
              &&
         s.getDepartment().equalsIgnoreCase(dept)) {

          System.out.println("Student Already Registered");
          return;

      }

  }

  int id = students.size() + 1;

  Student student = new Student(id, name, dept, password);

  students.add(student);

  System.out.println("\nStudent Registered Successfully");
  System.out.println("Your Student ID : " + id);

}

//=================================
//STUDENT LOGIN
//=================================

static Student studentLogin() {

 System.out.print("Enter Student ID : ");

 if (!sc.hasNextInt()) {

     System.out.println("Invalid Student ID (must be a number)");
     sc.next();
     return null;

 }

 int id = sc.nextInt();

 System.out.print("Enter Password : ");
 String password = sc.next();

 for(Student s : students) {

     if(s.getStudentId() == id
             &&
        s.getPassword().equals(password)) {

         return s;

     }

 }

 return null;

}

//=================================
//LOGIN FOR ISSUE BOOK
//=================================

static void loginForIssueBook() {

 Student student = studentLogin();

 if(student == null) {

     System.out.println("Invalid Student ID or Password");
     return;

 }

 issueBook(student);

}

//=================================
//LOGIN FOR RETURN BOOK
//=================================

static void loginForReturnBook() {

 Student student = studentLogin();

 if(student == null) {

     System.out.println("Invalid Student ID or Password");
     return;

 }

 returnBook(student);

}

}
