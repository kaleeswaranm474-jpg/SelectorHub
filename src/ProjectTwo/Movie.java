package ProjectTwo;

public class Movie {

    private int movieId;
    private String movieName;
    private String language;

    private boolean[][] seats;


    // Constructor

    public Movie(int movieId, String movieName, String language,
                 int rows, int cols) {

        this.movieId = movieId;
        this.movieName = movieName;
        this.language = language;

        seats = new boolean[rows][cols];
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


    public boolean[][] getSeats() {

        return seats;
    }



    // Display Movie Details

    public String toString() {

        return "Movie ID      : " + movieId +
               "\nMovie Name    : " + movieName +
               "\nLanguage      : " + language;
    }
}