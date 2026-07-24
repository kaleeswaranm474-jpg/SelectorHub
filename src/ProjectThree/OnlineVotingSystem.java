package ProjectThree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class OnlineVotingSystem {


    static Scanner sc = new Scanner(System.in);


    // Store Users
    static HashMap<String, User> users = new HashMap<>();


    // Store Candidates
    static ArrayList<Candidate> candidates = new ArrayList<>();


    // Store Voting Details
    static HashMap<String, Voting> votingDetails = new HashMap<>();


    // Register User

    static void registerUser() {


        System.out.print("Enter Username : ");
        String username = sc.next();


        System.out.print("Enter Password : ");
        String password = sc.next();

        
        if(users.containsKey(username)) {


            System.out.println("Username Already Exists");

        }

        else {


            User user = new User(username, password);


            users.put(username, user);

            System.out.println("Registration Successful");

        }

    }


    // Login User

    static User loginUser() {


        System.out.print("Enter Username : ");
        String username = sc.next();



        System.out.print("Enter Password : ");
        String password = sc.next();

        User user = users.get(username);



        if(user != null &&
           user.getPassword().equals(password)) {



            System.out.println("Login Successful");


            return user;

        }

        else {


            System.out.println("Invalid Username or Password");


            return null;

        }

    }


    // Candidate List

    static void viewCandidates() {


        if(candidates.isEmpty()) {


            System.out.println("No Candidates Available");

        }

        else {


            for(Candidate candidate : candidates) {


                System.out.println("\n----------------");

                System.out.println(candidate);

            }

        }

    }


    // Cast Vote

    static void castVote(User user) {



        if(user == null) {

            System.out.println("Please Login First");

            return;

        }

        if(user.isVoted()) {


            System.out.println("You Already Voted");

            return;

        }

        viewCandidates();

        System.out.print("Enter Candidate ID : ");

        int id = sc.nextInt();


        for(Candidate candidate : candidates) {

            if(candidate.getCandidateId() == id) {

                candidate.addVote();

                user.setVoted(true);


                Voting vote =
                    new Voting(user, candidate);

                votingDetails.put(
                    user.getUsername(),
                    vote);

                System.out.println(
                    "Vote Cast Successfully");

                return;

            }

        }

        System.out.println("Candidate Not Found");

    }

    // Display Result

    static void displayResult() {


        if(candidates.isEmpty()) {


            System.out.println("No Result Available");

            return;

        }



        Candidate winner = candidates.get(0);



        System.out.println("\n========== RESULT ==========");



        for(Candidate candidate : candidates) {


            System.out.println(
            candidate.getCandidateName()
            +" : "
            +candidate.getVotes()
            +" Votes");



            if(candidate.getVotes()
                    > winner.getVotes()) {


                winner = candidate;

            }

        }

        
        System.out.println(
        "\nWinner : "
        +winner.getCandidateName());

    }

 // Add Candidate

    static void addCandidate() {


        System.out.print("Enter Candidate ID : ");
        int id = sc.nextInt();


        sc.nextLine();


        System.out.print("Enter Candidate Name : ");
        String name = sc.nextLine();



        System.out.print("Enter Party Name : ");
        String party = sc.nextLine();



        Candidate candidate =
                new Candidate(id, name, party);

        candidates.add(candidate);

        System.out.println("Candidate Added Successfully");

    }


    public static void main(String[] args) {


        int choice;


        User currentUser = null;


        do {

            System.out.println(
            "\n========== ONLINE VOTING SYSTEM ==========");


            System.out.println("1. Register User");

            System.out.println("2. Login");

            System.out.println("3. Add Candidate");

            System.out.println("4. View Candidate List");

            System.out.println("5. Cast Vote");

            System.out.println("6. View Result");

            System.out.println("7. Exit");


            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch(choice) {



            case 1:

                registerUser();

                break;




            case 2:

                currentUser = loginUser();

                break;



            case 3:

                addCandidate();

                break;



            case 4:

                viewCandidates();

                break;



            case 5:

                castVote(currentUser);

                break;



            case 6:

                displayResult();

                break;



            case 7:

                System.out.println("Thank You...");

                break;


            default:

                System.out.println("Invalid Choice");

            }




        }while(choice != 6);



    }

}