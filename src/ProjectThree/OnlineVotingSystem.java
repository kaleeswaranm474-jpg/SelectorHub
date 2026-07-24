package ProjectThree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OnlineVotingSystem {

    static Scanner sc = new Scanner(System.in);

    // Store Users (Voter ID -> User)
    static HashMap<String, User> users = new HashMap<>();

    // Store Candidates
    static ArrayList<Candidate> candidates = new ArrayList<>();

    // Store Voting Details
    static HashMap<String, Voting> votingDetails = new HashMap<>();


    // ==============================
    // Default Tamil Nadu Candidates
    // ==============================

    static void addDefaultCandidates() {

        candidates.add(new Candidate(101, "M.K. Stalin", "DMK"));
        candidates.add(new Candidate(102, "Edappadi K. Palaniswami", "AIADMK"));
        candidates.add(new Candidate(103, "Vijay", "TVK"));
        candidates.add(new Candidate(104, "Annamalai", "BJP"));
        candidates.add(new Candidate(105, "Seeman", "NTK"));

    }


    // ==============================
    // Main Menu
    // ==============================

    static void mainMenu() {

        
        System.out.println("\n*************************************************");
        System.out.println("*                                               *");
        System.out.println("*          ONLINE VOTING SYSTEM                 *");
        System.out.println("*                                               *");
        System.out.println("*************************************************");
        System.out.println();
        System.out.println("1. User Module");
        System.out.println("2. Admin Login");
        System.out.println("3. Exit");
        System.out.print("Enter Your Choice : ");

    }


    // ==============================
    // User Menu
    // ==============================

    static void userMenu() {

        System.out.println("\n========== USER MODULE ==========");
        System.out.println("1. Register User");
        System.out.println("2. Login");
        System.out.println("3. View Candidates");
        System.out.println("4. Cast Vote");
        System.out.println("5. View Result");
        System.out.println("6. Back");
        System.out.print("Enter Your Choice : ");

    }


    // ==============================
    // Admin Login
    // ==============================

    static boolean adminLogin() {

        System.out.print("Enter Admin Username : ");
        String username = sc.next();

        System.out.print("Enter Admin Password : ");
        String password = sc.next();

        if(username.equals("Vishnu") &&
           password.equals("Vishnu123")) {

            System.out.println("\nAdmin Login Successful...");
            return true;
        }

        System.out.println("\nInvalid Admin Username or Password");
        return false;

    }


    // ==============================
    // Admin Menu
    // ==============================

    static void adminMenu() {

        System.out.println("\n========== ADMIN MODULE ==========");
        System.out.println("1. Add Candidate");
        System.out.println("2. View Candidates");
        System.out.println("3. View Result");
        System.out.println("4. Logout");
        System.out.print("Enter Your Choice : ");

    }
    // ==============================
    // Register User
    // ==============================

    static void registerUser() {

        sc.nextLine();

        System.out.print("Enter Voter ID : ");
        String voterId = sc.nextLine();

        if(users.containsKey(voterId)) {
            System.out.println("Voter ID Already Registered.");
            return;
        }

        System.out.print("Enter User Name : ");
        String userName = sc.nextLine();

        System.out.print("Enter Age : ");
        int age = sc.nextInt();

        if(age < 21) {
            System.out.println("You are not eligible to vote.");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Phone Number : ");
        String phone = sc.nextLine();

        if(!phone.matches("[6-9][0-9]{9}")) {
            System.out.println("Invalid Phone Number.");
            return;
        }
        

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        User user = new User(
                voterId,
                userName,
                password,
                age,
                phone);

        users.put(voterId, user);

        System.out.println("\nUser Registered Successfully.");
    }


    // ==============================
    // User Login
    // ==============================

    static User loginUser() {

        sc.nextLine();

        System.out.print("Enter Voter ID : ");
        String voterId = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        User user = users.get(voterId);

        if(user != null &&
           user.getPassword().equals(password)) {

            System.out.println("\nLogin Successful.");
            return user;
        }

        System.out.println("\nInvalid Voter ID or Password.");
        return null;
    }


    // ==============================
    // View Candidates
    // ==============================

    static void viewCandidates() {

        if(candidates.isEmpty()) {

            System.out.println("\nNo Candidates Available.");
            return;
        }

        System.out.println("\n========== CANDIDATE LIST ==========");

        for(Candidate candidate : candidates) {

            System.out.println("--------------------------------");

            System.out.println("Candidate ID   : "
                    + candidate.getCandidateId());

            System.out.println("Candidate Name : "
                    + candidate.getCandidateName());

            System.out.println("Party Name     : "
                    + candidate.getPartyName());

            System.out.println("--------------------------------");
        }

    }
    // ==============================
    // Cast Vote
    // ==============================

    static void castVote(User user) {

        if(user == null) {
            System.out.println("Please Login First.");
            return;
        }

        if(user.isVoted()) {
            System.out.println("You Have Already Voted.");
            return;
        }

        viewCandidates();

        System.out.print("Enter Candidate ID : ");
        int id = sc.nextInt();

        for(Candidate candidate : candidates) {

            if(candidate.getCandidateId() == id) {

                candidate.addVote();

                user.setVoted(true);

                Voting voting = new Voting(user, candidate);

                votingDetails.put(user.getVoterId(), voting);

                System.out.println("\nVote Cast Successfully.");
                return;
            }
        }

        System.out.println("Invalid Candidate ID.");
    }


    // ==============================
    // View Result
    // ==============================

    static void displayResult() {

        if(candidates.isEmpty()) {

            System.out.println("No Candidates Available.");
            return;
        }

        Candidate winner = candidates.get(0);

        System.out.println("\n========== ELECTION RESULT ==========");

        for(Candidate candidate : candidates) {

            System.out.println(
                    candidate.getCandidateName()
                    + " ("
                    + candidate.getPartyName()
                    + ") : "
                    + candidate.getVotes()
                    + " Votes");

            if(candidate.getVotes() > winner.getVotes()) {

                winner = candidate;
            }
        }

        System.out.println("\n==============================");
        System.out.println("Winner : " + winner.getCandidateName());
        System.out.println("Party  : " + winner.getPartyName());
        System.out.println("Votes  : " + winner.getVotes());
        System.out.println("==============================");
    }


    // ==============================
    // Add Candidate (Admin Only)
    // ==============================

    static void addCandidate() {

        System.out.print("Enter Candidate ID : ");
        int id = sc.nextInt();

        sc.nextLine();

        // Duplicate Candidate ID Check
        for(Candidate c : candidates) {

            if(c.getCandidateId() == id) {

                System.out.println("Candidate ID Already Exists.");
                return;
            }
        }

        System.out.print("Enter Candidate Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Party Name : ");
        String party = sc.nextLine();

        Candidate candidate =
                new Candidate(id, name, party);

        candidates.add(candidate);

        System.out.println("\nCandidate Added Successfully.");
    }
    
    // ==============================
    // Main Method
    // ==============================

    public static void main(String[] args) {

        // Default Candidates
        addDefaultCandidates();

        int mainChoice;
        User currentUser = null;

        do {

            mainMenu();
            mainChoice = sc.nextInt();

            switch(mainChoice) {

            // =========================
            // USER MODULE
            // =========================

            case 1:

                int userChoice;

                do {

                    userMenu();
                    userChoice = sc.nextInt();

                    switch(userChoice) {

                    case 1:
                        registerUser();
                        break;

                    case 2:
                        currentUser = loginUser();
                        break;

                    case 3:
                        viewCandidates();
                        break;

                    case 4:
                        castVote(currentUser);
                        break;

                    case 5:
                        displayResult();
                        break;

                    case 6:
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println("Invalid Choice.");
                    }

                } while(userChoice != 6);

                break;


            // =========================
            // ADMIN MODULE
            // =========================

            case 2:

                if(adminLogin()) {

                    int adminChoice;

                    do {

                        adminMenu();
                        adminChoice = sc.nextInt();

                        switch(adminChoice) {

                        case 1:
                            addCandidate();
                            break;

                        case 2:
                            viewCandidates();
                            break;

                        case 3:
                            displayResult();
                            break;

                        case 4:
                            System.out.println("Admin Logout Successfully...");
                            break;

                        default:
                            System.out.println("Invalid Choice.");
                        }

                    } while(adminChoice != 4);

                }

                break;


            // =========================
            // EXIT
            // =========================

            case 3:

                System.out.println("\n==================================");
                System.out.println(" Thank You For Using");
                System.out.println(" Online Voting System");
                System.out.println("==================================");

                break;

            default:
                System.out.println("Invalid Choice.");
            }

        } while(mainChoice != 3);

        sc.close();
    }
}