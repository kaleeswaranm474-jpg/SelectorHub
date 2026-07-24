package ProjectThree;

public class User {

    private String username;
    private String password;
    private boolean voted;


    // Constructor

    public User(String username, String password) {

        this.username = username;
        this.password = password;
        this.voted = false;
    }


    // Getter Methods

    public String getUsername() {

        return username;
    }


    public String getPassword() {

        return password;
    }


    public boolean isVoted() {

        return voted;
    }



    // Update Vote Status

    public void setVoted(boolean voted) {

        this.voted = voted;
    }



    public String toString() {

        return "Username : " + username +
               "\nVoted    : " + voted;
    }

}