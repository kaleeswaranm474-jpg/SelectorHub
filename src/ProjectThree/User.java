package ProjectThree;

public class User {

    private String voterId;
    private String userName;
    private String password;
    private int age;
    private String phoneNumber;
    private boolean voted;

    // Constructor
    public User(String voterId,
                String userName,
                String password,
                int age,
                String phoneNumber) {

        this.voterId = voterId;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.voted = false;
    }

    // Getters

    public String getVoterId() {
        return voterId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isVoted() {
        return voted;
    }

    // Setter

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    @Override
    public String toString() {

        return "\n========== USER DETAILS ==========" +
               "\nVoter ID      : " + voterId +
               "\nName          : " + userName +
               "\nAge           : " + age +
               "\nPhone Number  : " + phoneNumber +
               "\nVoted         : " + (voted ? "Yes" : "No");
    }
}