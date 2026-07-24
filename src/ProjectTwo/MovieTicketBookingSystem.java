package ProjectTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;


public class MovieTicketBookingSystem {


    static Scanner sc = new Scanner(System.in);


    // Store Customers
    static ArrayList<Customer> customers = new ArrayList<>();


    // Store Movies
    static ArrayList<Movie> movies = new ArrayList<>();


    // Store Tickets
    static HashMap<String, TicketBooking> bookings =
            new HashMap<>();


    // Current Login Customer
    static Customer currentCustomer = null;



    // ===============================
    // Main Menu
    // ===============================

    static void mainMenu() {


        System.out.println(
        "\n================================================");


        System.out.println(
        "          MOVIE TICKET BOOKING SYSTEM");


        System.out.println(
        "================================================");


        System.out.println(
        "1. Customer Module");


        System.out.println(
        "2. Admin Login");


        System.out.println(
        "3. Exit");


        System.out.print(
        "Enter Your Choice : ");

    }






    // ===============================
    // Customer Registration
    // ===============================

    static void registerCustomer() {



        System.out.println(
        "\n========== CUSTOMER REGISTRATION ==========");



        System.out.print(
        "Enter Customer ID : ");

        int id = sc.nextInt();






        for(Customer c : customers) {



            if(c.getCustomerId() == id) {


                System.out.println(
                "Customer ID Already Exists.");


                return;

            }

        }







        sc.nextLine();


        System.out.print(
        "Enter Customer Name : ");


        String name = sc.nextLine();






        System.out.print(
        "Enter Age : ");


        int age = sc.nextInt();






        String phone;



        while(true) {



            System.out.print(
            "Enter Phone Number : ");



            phone = sc.next();






            if(phone.matches("[6789][0-9]{9}")) {


                break;


            }

            else {


                System.out.println(
                "Invalid Phone Number.");


                System.out.println(
                "Phone number must start with 6/7/8/9");

            }


        }







        System.out.print(
        "Create Password : ");



        String password = sc.next();







        Customer customer =
        new Customer(
                id,
                name,
                age,
                phone,
                password);







        customers.add(customer);



        currentCustomer = customer;






        System.out.println(
        "\nCustomer Registered Successfully.");

    }
    
    // ===============================
    // Customer Module Menu
    // ===============================

    static void customerMenu() {


        System.out.println(
        "\n=============== CUSTOMER MODULE ===============");


        System.out.println(
        "1. Movie Details");


        System.out.println(
        "2. Ticket Booking");


        System.out.println(
        "3. Back");


        System.out.print(
        "Enter Your Choice : ");

    }







    // ===============================
    // Movie Details Menu
    // ===============================

    static void movieDetailsMenu() {


        System.out.println(
        "\n=============== MOVIE DETAILS ===============");


        System.out.println(
        "1. View Movies");


        System.out.println(
        "2. Search Movie");


        System.out.println(
        "3. Show Available Seats");


        System.out.println(
        "4. Back");


        System.out.print(
        "Enter Your Choice : ");

    }







    // ===============================
    // Booking Menu
    // ===============================

    static void bookingMenu() {


        System.out.println(
        "\n=============== BOOKING MODULE ===============");


        System.out.println(
        "1. Book Ticket");


        System.out.println(
        "2. Show My Ticket");


        System.out.println(
        "3. Cancel Ticket");


        System.out.println(
        "4. Back");


        System.out.print(
        "Enter Your Choice : ");

    }







    // ===============================
    // Add Default Movies
    // ===============================

    static void addDefaultMovies() {



        movies.add(
        new Movie(
                101,
                "Coolie",
                "Tamil",
                180));


        movies.add(
        new Movie(
                102,
                "GOAT",
                "Tamil",
                150));


        movies.add(
        new Movie(
                103,
                "Dragon",
                "Tamil",
                160));


        movies.add(
        new Movie(
                104,
                "Vettaiyan",
                "Tamil",
                170));


    }








    // ===============================
    // View Movies
    // ===============================

    static void viewMovies() {


        System.out.println(
        "\n============= MOVIE LIST =============");



        for(Movie movie : movies) {


            System.out.println(
            "--------------------------------");


            System.out.println(movie);


        }


    }









    // ===============================
    // Search Movie
    // ===============================

    static void searchMovie() {


        sc.nextLine();



        System.out.print(
        "Enter Movie Name : ");



        String name = sc.nextLine();







        for(Movie movie : movies) {



            if(movie.getMovieName()
                    .equalsIgnoreCase(name)) {



                System.out.println(
                "\nMovie Found");


                System.out.println(movie);


                return;

            }


        }






        System.out.println(
        "Movie Not Found.");

    }









    // ===============================
    // Show Seat Availability
    // ===============================

    static void showAvailableSeats() {



        Movie movie = movies.get(0);



        boolean seats[][] =
                movie.getSeats();






        System.out.println(
        "\n===================================");


        System.out.println(
        "             SCREEN");


        System.out.println(
        "===================================");




        System.out.println(
        "\n       1    2    3    4    5\n");




        char row = 'A';





        for(int i=0;i<seats.length;i++) {



            System.out.print(
            row + "   ");



            for(int j=0;j<seats[i].length;j++) {



                if(seats[i][j]) {


                    System.out.print("[X]  ");


                }

                else {


                    System.out.print("[ ]  ");

                }


            }



            System.out.println();


            row++;

        }




        System.out.println(
        "\n[ ] Available  [X] Booked");

    }
    
    // ===============================
    // Book Ticket
    // ===============================

    static void bookTicket(Customer customer) {



        viewMovies();



        System.out.print(
        "\nEnter Movie ID : ");


        int movieId = sc.nextInt();






        Movie selectedMovie = null;






        for(Movie movie : movies) {



            if(movie.getMovieId() == movieId) {



                selectedMovie = movie;

                break;

            }

        }






        if(selectedMovie == null) {


            System.out.println(
            "Movie Not Found.");

            return;

        }








        showAvailableSeats();







        System.out.print(
        "\nHow Many Seats Do You Want : ");


        int seatCount = sc.nextInt();







        ArrayList<String> seats =
                new ArrayList<>();








        for(int i=1; i<=seatCount; i++) {



            System.out.println(
            "\nSelect Seat " + i);



            System.out.print(
            "Enter Row (A/B/C) : ");



            char rowChar =
            Character.toUpperCase(
            sc.next().charAt(0));





            System.out.print(
            "Enter Seat Number : ");



            int seatNumber =
                    sc.nextInt();






            int row = rowChar - 'A';


            int col = seatNumber - 1;








            if(row < 0 || row >= 3 ||
               col < 0 || col >= 5) {



                System.out.println(
                "Invalid Seat.");


                i--;

                continue;

            }









            if(selectedMovie.getSeats()
                    [row][col]) {



                System.out.println(
                "Seat Already Booked.");


                i--;

                continue;

            }









            selectedMovie.getSeats()
                    [row][col] = true;







            seats.add(
            rowChar + "" + seatNumber);



        }







        String bookingId =
                "B" + (bookings.size()+1);







        TicketBooking ticket =
        new TicketBooking(
                bookingId,
                selectedMovie,
                customer,
                seats,
                LocalDate.now());








        bookings.put(
                bookingId,
                ticket);








        System.out.println(
        "\n===================================");


        System.out.println(
        "Ticket Booked Successfully");


        System.out.println(
        "Booking ID : " + bookingId);


        System.out.println(
        "Selected Seats : " + seats);


        System.out.println(
        "===================================");


    }









    // ===============================
    // Show My Ticket
    // ===============================

    static void showMyTicket(Customer customer) {



        boolean found = false;





        System.out.println(
        "\n=========== MY TICKET ===========");







        for(String id : bookings.keySet()) {



            TicketBooking ticket =
                    bookings.get(id);








            if(ticket.getCustomer()
                    .getCustomerId()
                    ==
                    customer.getCustomerId()) {




                System.out.println(ticket);


                found = true;


            }



        }






        if(!found) {


            System.out.println(
            "No Ticket Found.");

        }

    }









    // ===============================
    // Cancel Ticket
    // ===============================

    static void cancelTicket(Customer customer) {



        System.out.print(
        "Enter Booking ID : ");



        String bookingId =
                sc.next();

        TicketBooking ticket =
                bookings.get(bookingId);


        if(ticket != null
        &&
        ticket.getCustomer()
        .getCustomerId()
        ==
        customer.getCustomerId()) {





            ticket.cancelTicket();



            bookings.remove(bookingId);






            System.out.println(
            "Ticket Cancelled Successfully.");



        }

        else {


            System.out.println(
            "Invalid Booking ID.");

        }

    }
    
    // ===============================
    // Admin Login
    // ===============================

    static boolean adminLogin() {


        System.out.print(
        "Enter Admin Username : ");


        String username = sc.next();




        System.out.print(
        "Enter Admin Password : ");


        String password = sc.next();






        if(username.equals("Vishnu")
                &&
           password.equals("Vishnu123")) {



            System.out.println(
            "\nAdmin Login Successful");


            return true;

        }

        else {


            System.out.println(
            "\nInvalid Admin Login");


            return false;

        }


    }









    // ===============================
    // Add Movie
    // ===============================

    static void addMovie() {



        System.out.print(
        "Enter Movie ID : ");


        int id = sc.nextInt();




        sc.nextLine();



        System.out.print(
        "Enter Movie Name : ");


        String name = sc.nextLine();





        System.out.print(
        "Enter Language : ");


        String language = sc.nextLine();






        System.out.print(
        "Enter Ticket Price : ");


        double price = sc.nextDouble();






        movies.add(
        new Movie(
                id,
                name,
                language,
                price));






        System.out.println(
        "Movie Added Successfully.");

    }








    // ===============================
    // View All Tickets
    // ===============================

    static void viewAllBookings() {



        if(bookings.isEmpty()) {


            System.out.println(
            "No Tickets Available.");

            return;

        }







        System.out.println(
        "\n=========== ALL TICKETS ===========");






        for(String id : bookings.keySet()) {



            System.out.println(
            bookings.get(id));


            System.out.println(
            "-------------------------");

        }


    }









    // ===============================
    // MAIN METHOD
    // ===============================

    public static void main(String[] args) {



        addDefaultMovies();



        int choice;



        do {



            mainMenu();



            choice = sc.nextInt();





            switch(choice) {




            // =======================
            // CUSTOMER MODULE
            // =======================

            case 1:



                registerCustomer();





                int customerChoice;




                do {



                    customerMenu();



                    customerChoice =
                            sc.nextInt();







                    switch(customerChoice) {




                    case 1:



                        int movieChoice;



                        do {



                            movieDetailsMenu();



                            movieChoice =
                                    sc.nextInt();







                            switch(movieChoice) {



                            case 1:

                                viewMovies();

                                break;




                            case 2:

                                searchMovie();

                                break;




                            case 3:

                                showAvailableSeats();

                                break;




                            case 4:

                                break;



                            default:

                                System.out.println(
                                "Invalid Choice.");

                            }




                        }while(movieChoice != 4);



                        break;









                    case 2:



                        int bookingChoice;



                        do {



                            bookingMenu();



                            bookingChoice =
                                    sc.nextInt();







                            switch(bookingChoice) {



                            case 1:

                                bookTicket(
                                currentCustomer);

                                break;




                            case 2:

                                showMyTicket(
                                currentCustomer);

                                break;




                            case 3:

                                cancelTicket(
                                currentCustomer);

                                break;




                            case 4:

                                break;



                            default:

                                System.out.println(
                                "Invalid Choice.");

                            }




                        }while(bookingChoice != 4);



                        break;









                    case 3:


                        break;



                    default:

                        System.out.println(
                        "Invalid Choice.");

                    }




                }while(customerChoice != 3);





                break;









            // =======================
            // ADMIN MODULE
            // =======================

            case 2:



                if(adminLogin()) {



                    int adminChoice;



                    do {



                        System.out.println(
                        "\n=============== ADMIN MODULE ===============");


                        System.out.println(
                        "1. Add Movie");


                        System.out.println(
                        "2. View Movies");


                        System.out.println(
                        "3. View All Tickets");


                        System.out.println(
                        "4. View Seat Availability");


                        System.out.println(
                        "5. Logout");



                        System.out.print(
                        "Enter Your Choice : ");




                        adminChoice =
                                sc.nextInt();






                        switch(adminChoice) {



                        case 1:

                            addMovie();

                            break;



                        case 2:

                            viewMovies();

                            break;



                        case 3:

                            viewAllBookings();

                            break;



                        case 4:

                            showAvailableSeats();

                            break;



                        case 5:

                            System.out.println(
                            "Admin Logout Successfully.");

                            break;



                        default:

                            System.out.println(
                            "Invalid Choice.");

                        }





                    }while(adminChoice != 5);



                }



                break;









            case 3:


                System.out.println(
                "Thank You...");


                break;






            default:


                System.out.println(
                "Invalid Choice.");

            }





        }while(choice != 3);




    }

}