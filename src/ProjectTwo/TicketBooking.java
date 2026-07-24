package ProjectTwo;

import java.time.LocalDate;


public class TicketBooking {


    private Movie movie;

    private Customer customer;

    private int row;

    private int seat;

    private LocalDate bookingDate;




    // Constructor

    public TicketBooking(Movie movie,
                         Customer customer,
                         int row,
                         int seat,
                         LocalDate bookingDate) {


        this.movie = movie;

        this.customer = customer;

        this.row = row;

        this.seat = seat;

        this.bookingDate = bookingDate;

    }




    // Cancel Ticket

    public void cancelTicket() {


        movie.getSeats()[row][seat] = false;

    }






    // Display Booking Details

    public String toString() {


        return "Customer Name : "
                + customer.getCustomerName()

                + "\nMovie Name : "
                + movie.getMovieName()

                + "\nRow : "
                + (row+1)

                + "\nSeat : "
                + (seat+1)

                + "\nBooking Date : "
                + bookingDate;

    }


}