package ProjectTwo;

import java.time.LocalDate;
import java.util.ArrayList;


public class TicketBooking {


    private String bookingId;

    private Movie movie;

    private Customer customer;


    // Multiple seats store

    private ArrayList<String> seats;


    private LocalDate bookingDate;




    // Constructor

    public TicketBooking(String bookingId,
                         Movie movie,
                         Customer customer,
                         ArrayList<String> seats,
                         LocalDate bookingDate) {


        this.bookingId = bookingId;

        this.movie = movie;

        this.customer = customer;

        this.seats = seats;

        this.bookingDate = bookingDate;

    }





    // Getter Methods


    public String getBookingId() {

        return bookingId;

    }




    public Customer getCustomer() {

        return customer;

    }




    public ArrayList<String> getSeats() {

        return seats;

    }






    // Cancel Ticket

    public void cancelTicket() {


        for(String seat : seats) {



            char rowName = seat.charAt(0);


            int seatNumber =
                    Integer.parseInt(
                    seat.substring(1));



            int row = rowName - 'A';


            int column = seatNumber - 1;



            movie.getSeats()[row][column] = false;


        }


    }






    // Display Ticket Details


    public String toString() {



        return "\nBooking ID    : " + bookingId

                + "\nCustomer Name : "
                + customer.getCustomerName()

                + "\nMovie Name    : "
                + movie.getMovieName()

                + "\nSeats         : "
                + seats

                + "\nTotal Seats   : "
                + seats.size()

                + "\nBooking Date  : "
                + bookingDate;

    }


}