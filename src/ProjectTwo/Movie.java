package ProjectTwo;

public class Movie {

    private int movieId;
    private String movieName;
    private String language;
    private double ticketPrice;

    // 3 Rows (A,B,C) × 5 Seats (1-5)
    private boolean[][] seats = new boolean[3][5];

    // Constructor
    public Movie(int movieId,
                 String movieName,
                 String language,
                 double ticketPrice) {

        this.movieId = movieId;
        this.movieName = movieName;
        this.language = language;
        this.ticketPrice = ticketPrice;
    }

    // Getter Methods

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getLanguage() {
        return language;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public boolean[][] getSeats() {
        return seats;
    }

    // Display Movie Details
    @Override
    public String toString() {

        return "Movie ID      : " + movieId
                + "\nMovie Name    : " + movieName
                + "\nLanguage      : " + language
                + "\nTicket Price  : ₹" + ticketPrice;
    }

}