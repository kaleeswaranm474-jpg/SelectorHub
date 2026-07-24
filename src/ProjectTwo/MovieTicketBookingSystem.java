package ProjectTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;


public class MovieTicketBookingSystem {


    static Scanner sc = new Scanner(System.in);


    static ArrayList<Movie> movies = new ArrayList<>();


    static ArrayList<Customer> customers = new ArrayList<>();


    static HashMap<String, TicketBooking> bookings = new HashMap<>();





    // Add Movie

    static void addMovie() {


        System.out.print("Enter Movie ID : ");
        int id = sc.nextInt();

        sc.nextLine();


        System.out.print("Enter Movie Name : ");
        String name = sc.nextLine();


        System.out.print("Enter Language : ");
        String language = sc.nextLine();



        Movie movie = new Movie(id, name, language, 3, 5);


        movies.add(movie);



        System.out.println("Movie Added Successfully");

    }





    // View Movies

    static void viewMovies() {


        if(movies.isEmpty()) {

            System.out.println("No Movies Available");

        }

        else {


            for(Movie movie : movies) {


                System.out.println("\n----------------");

                System.out.println(movie);

            }

        }

    }






    // Search Movie

    static void searchMovie() {


        sc.nextLine();


        System.out.print("Enter Movie Name : ");

        String name = sc.nextLine();



        for(Movie movie : movies) {


            if(movie.getMovieName()
                    .equalsIgnoreCase(name)) {


                System.out.println(movie);

                return;

            }

        }



        System.out.println("Movie Not Found");

    }






    // Add Customer

    static void addCustomer() {


        System.out.print("Enter Customer ID : ");

        int id = sc.nextInt();


        sc.nextLine();



        System.out.print("Enter Customer Name : ");

        String name = sc.nextLine();



        System.out.print("Enter Phone Number : ");

        String phone = sc.nextLine();




        Customer customer =
                new Customer(id, name, phone);



        customers.add(customer);



        System.out.println("Customer Added Successfully");

    }






    // View Customers

    static void viewCustomers() {


        if(customers.isEmpty()) {


            System.out.println("No Customers Available");

        }

        else {


            for(Customer customer : customers) {


                System.out.println("\n----------------");

                System.out.println(customer);

            }

        }

    }






    // Search Customer

    static void searchCustomer() {


        System.out.print("Enter Customer ID : ");

        int id = sc.nextInt();



        for(Customer customer : customers) {


            if(customer.getCustomerId() == id) {


                System.out.println(customer);

                return;

            }

        }


        System.out.println("Customer Not Found");

    }








    // Show Seats

    static void showAvailableSeats() {


        if(movies.isEmpty()) {


            System.out.println("Add Movie First");

            return;

        }



        Movie movie = movies.get(0);



        boolean seats[][] = movie.getSeats();




        for(int i=0; i<seats.length; i++) {


            for(int j=0; j<seats[i].length; j++) {



                if(seats[i][j]) {

                    System.out.print("[X] ");

                }

                else {

                    System.out.print("["+(i+1)+
                            "-"+(j+1)+"] ");

                }

            }


            System.out.println();

        }


    }

    // Book Ticket

    static void bookTicket() {



        if(movies.isEmpty() || customers.isEmpty()) {


            System.out.println("Movie and Customer Required");

            return;

        }

        Movie movie = movies.get(0);


        Customer customer = customers.get(0);




        showAvailableSeats();


        System.out.print("Enter Row Number : ");

        int row = sc.nextInt()-1;




        System.out.print("Enter Seat Number : ");

        int seat = sc.nextInt()-1;





        if(movie.getSeats()[row][seat] == false) {



            movie.getSeats()[row][seat] = true;



            String bookingId =
                    "B" + (bookings.size()+1);




            TicketBooking ticket =
                    new TicketBooking(
                    movie,
                    customer,
                    row,
                    seat,
                    LocalDate.now());




            bookings.put(bookingId, ticket);




            System.out.println("Ticket Booked Successfully");

            System.out.println("Booking ID : "
                    + bookingId);


        }

        else {


            System.out.println("Seat Already Booked");

        }


    }


    // Cancel Ticket

    static void cancelTicket() {


        System.out.print("Enter Booking ID : ");

        String id = sc.next();



        TicketBooking ticket =
                bookings.get(id);



        if(ticket != null) {


            ticket.cancelTicket();


            bookings.remove(id);



            System.out.println(
                    "Ticket Cancelled Successfully");


        }

        else {


            System.out.println(
                    "Booking Not Found");

        }

    }








    // View Bookings

    static void viewBookings() {


        if(bookings.isEmpty()) {


            System.out.println("No Bookings Available");

        }

        else {


            for(String id : bookings.keySet()) {



                System.out.println(
                        "\nBooking ID : " + id);



                System.out.println(
                        bookings.get(id));


            }

        }

    }









    public static void main(String[] args) {



        int choice;



        do {


            System.out.println(
            "\n========== MOVIE TICKET BOOKING SYSTEM ==========");


            System.out.println("1. Add Movie");

            System.out.println("2. View Movies");

            System.out.println("3. Search Movie");

            System.out.println("4. Add Customer");

            System.out.println("5. View Customers");

            System.out.println("6. Search Customer");

            System.out.println("7. Show Available Seats");

            System.out.println("8. Book Ticket");

            System.out.println("9. Cancel Ticket");

            System.out.println("10. View Bookings");

            System.out.println("11. Exit");



            System.out.print("Enter Choice : ");

            choice = sc.nextInt();





            switch(choice) {


            case 1:
                addMovie();
                break;


            case 2:
                viewMovies();
                break;


            case 3:
                searchMovie();
                break;


            case 4:
                addCustomer();
                break;


            case 5:
                viewCustomers();
                break;


            case 6:
                searchCustomer();
                break;


            case 7:
                showAvailableSeats();
                break;


            case 8:
                bookTicket();
                break;


            case 9:
                cancelTicket();
                break;


            case 10:
                viewBookings();
                break;


            case 11:

                System.out.println("Thank You...");

                break;


            default:

                System.out.println("Invalid Choice");

            }



        }while(choice != 11);


    }

}