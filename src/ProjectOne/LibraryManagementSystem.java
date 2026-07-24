package ProjectOne;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;



public class LibraryManagementSystem {


    static Scanner sc = new Scanner(System.in);



    static ArrayList<Book> books = new ArrayList<>();


    static ArrayList<Student> students = new ArrayList<>();


    static HashMap<String, BookIssue> issuedBooks = new HashMap<>();





    public static void main(String[] args) {



        addDefaultBooks();

        addDefaultStudents();




        int choice;



        do {



            System.out.println(
            "\n================================================");


            System.out.println(
            "          LIBRARY MANAGEMENT SYSTEM");


            System.out.println(
            "================================================");


            System.out.println(
            "1. Librarian");


            System.out.println(
            "2. Student");


            System.out.println(
            "3. Exit");


            System.out.print(
            "Enter Choice : ");



            choice = sc.nextInt();






            switch(choice) {



            case 1:


                if(librarianLogin()) {


                    librarianMenu();


                }


                break;





            case 2:


            	  registerStudent();

                break;





            case 3:


                System.out.println(
                "Thank You...");


                break;





            default:


                System.out.println(
                "Invalid Choice");


            }





        }while(choice != 3);



    }








    // =================================
    // DEFAULT BOOKS
    // =================================


    static void addDefaultBooks() {



        books.add(
        new Book(101,"Java Programming",
        "James Gosling",5));


        books.add(
        new Book(102,"Python Basics",
        "Guido",4));


        books.add(
        new Book(103,"SQL Fundamentals",
        "Oracle",5));


        books.add(
        new Book(104,"Database Management",
        "C.J.Date",3));


        books.add(
        new Book(105,"HTML and CSS",
        "Jon Duckett",4));


        books.add(
        new Book(106,"JavaScript",
        "Brendan Eich",5));


        books.add(
        new Book(107,"Spring Boot",
        "Pivotal",3));


        books.add(
        new Book(108,"Data Structure",
        "Mark Allen",4));


        books.add(
        new Book(109,"Operating System",
        "Galvin",3));


        books.add(
        new Book(110,"Computer Network",
        "Tanenbaum",4));


        books.add(
        new Book(111,"Software Engineering",
        "Pressman",3));


        books.add(
        new Book(112,"Artificial Intelligence",
        "Russell",2));


        books.add(
        new Book(113,"Machine Learning",
        "Tom Mitchell",3));


        books.add(
        new Book(114,"Cyber Security",
        "William",4));


        books.add(
        new Book(115,"Cloud Computing",
        "Rajkumar",3));



    }







    // =================================
    // DEFAULT STUDENTS
    // =================================


    static void addDefaultStudents() {



        students.add(
        new Student(
        1,
        "Arun",
        "CSE",
        "123"));



        students.add(
        new Student(
        2,
        "Kumar",
        "IT",
        "456"));



        students.add(
        new Student(
        3,
        "Vishnu",
        "ECE",
        "789"));



    }







    // =================================
    // LIBRARIAN LOGIN
    // =================================


    static boolean librarianLogin() {



        System.out.print(
        "Enter Librarian ID : ");


        String id = sc.next();



        System.out.print(
        "Enter Password : ");


        String password = sc.next();





        if(id.equals("Vishnu")
                &&
           password.equals("Vishnu123")) {



            System.out.println(
            "Librarian Login Successful");


            return true;


        }


        else {



            System.out.println(
            "Invalid Librarian Login");


            return false;


        }



    }
    
    // =================================
    // LIBRARIAN MENU
    // =================================


    static void librarianMenu() {



        int choice;



        do {



            System.out.println(
            "\n=============== LIBRARIAN MENU ===============");


            System.out.println(
            "1. Add Book");


            System.out.println(
            "2. Remove Book");


            System.out.println(
            "3. View All Books");


            System.out.println(
            "4. Search Book");


            System.out.println(
            "5. Add Student");


            System.out.println(
            "6. View All Students");


            System.out.println(
            "7. Search Student");


            System.out.println(
            "8. View Issued Books");


            System.out.println(
            "9. Fine Calculation");


            System.out.println(
            "10. Manage Records");


            System.out.println(
            "11. Logout");



            System.out.print(
            "Enter Choice : ");



            choice = sc.nextInt();





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

                addStudent();

                break;



            case 6:

                viewStudents();

                break;



            case 7:

                searchStudent();

                break;



            case 8:

                viewIssuedBooks();

                break;



            case 9:

                calculateFine();

                break;



            case 10:

                manageRecords();

                break;



            case 11:

                System.out.println(
                "Logout Successfully");

                break;



            default:

                System.out.println(
                "Invalid Choice");

            }




        }while(choice != 11);



    }









    // =================================
    // ADD BOOK
    // =================================


    static void addBook() {



        System.out.print(
        "Enter Book ID : ");


        int id = sc.nextInt();
        
        for(Book b : books) {


            if(b.getBookId() == id) {


                System.out.println(
                "Book Already Exists");


                return;

            }

        }


        sc.nextLine();



        System.out.print(
        "Enter Book Name : ");


        String name = sc.nextLine();





        System.out.print(
        "Enter Author Name : ");


        String author = sc.nextLine();





        System.out.print(
        "Enter Available Copies : ");


        int copies = sc.nextInt();






        books.add(
        new Book(
        id,
        name,
        author,
        copies));





        System.out.println(
        "Book Added Successfully");


    }









    // =================================
    // REMOVE BOOK
    // =================================


    static void removeBook() {



        System.out.print(
        "Enter Book ID : ");


        int id = sc.nextInt();





        for(Book b : books) {



            if(b.getBookId() == id) {



                books.remove(b);



                System.out.println(
                "Book Removed Successfully");


                return;


            }


        }





        System.out.println(
        "Book Not Found");


    }









    // =================================
    // VIEW BOOKS
    // =================================


    static void viewBooks() {



        if(books.isEmpty()) {



            System.out.println(
            "No Books Available");


            return;

        }





        System.out.println(
        "\n=========== BOOK LIST ===========");





        for(Book b : books) {



            System.out.println(b);



            System.out.println(
            "-------------------------");


        }



    }









    // =================================
    // SEARCH BOOK
    // =================================


    static void searchBook() {



        System.out.print(
        "Enter Book ID : ");



        int id = sc.nextInt();






        for(Book b : books) {



            if(b.getBookId() == id) {



                System.out.println(b);


                return;


            }


        }






        System.out.println(
        "Book Not Found");


    }









    // =================================
    // ADD STUDENT
    // =================================


    static void addStudent() {



        System.out.print(
        "Enter Student ID : ");


        int id = sc.nextInt();


        sc.nextLine();





        System.out.print(
        "Enter Student Name : ");



        String name = sc.nextLine();





        System.out.print(
        "Enter Department : ");



        String dept = sc.nextLine();





        System.out.print(
        "Create Password : ");



        String password = sc.next();


        for(Student s : students) {


            if(s.getStudentName().equalsIgnoreCase(name)
               &&
               s.getDepartment().equalsIgnoreCase(dept)) {



                System.out.println(
                "Student Already Exists");


                return;

            }

        }



        students.add(
        new Student(
        id,
        name,
        dept,
        password));






        System.out.println(
        "Student Added Successfully");


    }









    // =================================
    // VIEW STUDENTS
    // =================================


    static void viewStudents() {



        if(students.isEmpty()) {



            System.out.println(
            "No Students Available");


            return;

        }





        System.out.println(
        "\n=========== STUDENT LIST ===========");





        for(Student s : students) {



            System.out.println(s);



            System.out.println(
            "-------------------------");


        }



    }









    // =================================
    // SEARCH STUDENT
    // =================================


    static void searchStudent() {



        System.out.print(
        "Enter Student ID : ");



        int id = sc.nextInt();






        for(Student s : students) {



            if(s.getStudentId() == id) {



                System.out.println(s);


                return;


            }


        }






        System.out.println(
        "Student Not Found");


    }
    
 // =================================
 // STUDENT REGISTER
 // =================================

 static void registerStudent() {


     sc.nextLine();


     System.out.print(
     "Enter Student Name : ");

     String name = sc.nextLine();



     System.out.print(
     "Enter Department : ");

     String dept = sc.nextLine();



     System.out.print(
     "Create Password : ");

     String password = sc.next();


     for(Student s : students) {


    	    if(s.getStudentName().equalsIgnoreCase(name)
    	       &&
    	       s.getDepartment().equalsIgnoreCase(dept)) {


    	        System.out.println(
    	        "Student Already Exists");


    	        return;

    	    }

    	}


     int id = students.size() + 1;




     Student student =
     new Student(
     id,
     name,
     dept,
     password);




     students.add(student);




     System.out.println(
     "\nStudent Registered Successfully");



     System.out.println(
     "Your Student ID : "
     + id);




     studentMenu(student);


 }
    // =================================
    // STUDENT MENU
    // =================================


    static void studentMenu(Student student) {



        int choice;



        do {



            System.out.println(
            "\n=============== STUDENT MENU ===============");



            System.out.println(
            "1. View All Books");


            System.out.println(
            "2. Search Book");


            System.out.println(
            "3. Issue Book");


            System.out.println(
            "4. Return Book");


            System.out.println(
            "5. View My Issued Books");


            System.out.println(
            "6. Logout");



            System.out.print(
            "Enter Choice : ");


            choice = sc.nextInt();






            switch(choice) {



            case 1:

                viewBooks();

                break;



            case 2:

                searchBook();

                break;



            case 3:

                issueBook(student);

                break;



            case 4:

                returnBook(student);

                break;



            case 5:

                viewMyIssuedBooks(student);

                break;



            case 6:

                System.out.println(
                "Logout Successfully");

                break;



            default:

                System.out.println(
                "Invalid Choice");


            }



        }while(choice != 6);



    }









    // =================================
    // ISSUE BOOK
    // =================================


    static void issueBook(Student student) {



        System.out.print(
        "Enter Book ID : ");



        int id = sc.nextInt();






        Book book = null;





        for(Book b : books) {



            if(b.getBookId() == id) {



                book = b;

                break;


            }


        }






        if(book == null) {



            System.out.println(
            "Book Not Found");


            return;


        }






        if(book.getAvailableCopies() <= 0) {



            System.out.println(
            "Book Not Available");


            return;


        }






        sc.nextLine();



        System.out.print(
        "Enter Issue Date (yyyy-MM-dd) : ");



        String date = sc.nextLine();





        LocalDate issueDate =
        LocalDate.parse(date);






        BookIssue issue =
        new BookIssue(
        book,
        student,
        issueDate);







        book.setAvailableCopies(
        book.getAvailableCopies()-1);






        issuedBooks.put(
        student.getStudentId()+"",
        issue);







        System.out.println(
        "Book Issued Successfully");


    }



 // =================================
 // RETURN BOOK
 // =================================

 static void returnBook(Student student) {


     System.out.print(
     "Enter Book ID : ");


     int bookId = sc.nextInt();



     BookIssue issue = null;



     for(BookIssue b : issuedBooks.values()) {


         if(b.getStudent().getStudentId() == student.getStudentId()
                 &&
            b.getBook().getBookId() == bookId) {


             issue = b;

             break;

         }

     }




     if(issue == null) {


         System.out.println(
         "Book Issue Record Not Found");


         return;

     }





     sc.nextLine();



     System.out.print(
     "Enter Return Date (yyyy-MM-dd) : ");



     String date = sc.nextLine();



     LocalDate returnDate =
     LocalDate.parse(date);




     issue.returnBook(returnDate);





     Book book =
     issue.getBook();




     book.setAvailableCopies(
     book.getAvailableCopies()+1);





     System.out.println(
     "Book Returned Successfully");



     System.out.println(
     "Fine Amount : ₹"
     + issue.calculateFine());




     issuedBooks.remove(
     student.getStudentId()+"");



 }



    // =================================
    // VIEW MY ISSUED BOOKS
    // =================================


    static void viewMyIssuedBooks(Student student) {



        String key =
        student.getStudentId()+"";





        BookIssue issue =
        issuedBooks.get(key);






        if(issue == null) {



            System.out.println(
            "No Issued Books");


            return;


        }







        System.out.println(
        "\n=========== MY BOOK DETAILS ===========");





        System.out.println(issue);



    }
    

    // =================================
    // VIEW ISSUED BOOKS
    // =================================


    static void viewIssuedBooks() {



        if(issuedBooks.isEmpty()) {



            System.out.println(
            "No Books Issued");


            return;


        }







        System.out.println(
        "\n=========== ISSUED BOOK DETAILS ===========");







        for(BookIssue issue : issuedBooks.values()) {



            System.out.println(issue);



            System.out.println(
            "--------------------------------");


        }



    }









    // =================================
    // FINE CALCULATION
    // =================================


    static void calculateFine() {



        if(issuedBooks.isEmpty()) {



            System.out.println(
            "No Issued Books");


            return;


        }






        System.out.println(
        "\n=========== FINE DETAILS ===========");







        for(BookIssue issue : issuedBooks.values()) {



            System.out.println(
            "Student Name : "
            + issue.getStudent().getStudentName());



            System.out.println(
            "Book Name : "
            + issue.getBook().getBookName());



            System.out.println(
            "Issue Date : "
            + issue.getIssueDate());



            System.out.println(
            "Return Date : "
            + issue.getReturnDate());



            System.out.println(
            "Fine Amount : ₹"
            + issue.calculateFine());



            System.out.println(
            "--------------------------------");



        }




    }









    // =================================
    // MANAGE RECORDS
    // =================================


    static void manageRecords() {



        int choice;



        do {



            System.out.println(
            "\n=========== MANAGE RECORDS ===========");



            System.out.println(
            "1. Total Books");


            System.out.println(
            "2. Total Students");


            System.out.println(
            "3. Total Issued Books");


            System.out.println(
            "4. Back");



            System.out.print(
            "Enter Choice : ");




            choice = sc.nextInt();






            switch(choice) {



            case 1:



                System.out.println(
                "Total Books : "
                + books.size());


                break;





            case 2:



                System.out.println(
                "Total Students : "
                + students.size());


                break;





            case 3:



                System.out.println(
                "Total Issued Books : "
                + issuedBooks.size());


                break;





            case 4:


                break;





            default:


                System.out.println(
                "Invalid Choice");



            }




        }while(choice != 4);



    }



}