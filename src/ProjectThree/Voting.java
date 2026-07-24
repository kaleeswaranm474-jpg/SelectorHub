package ProjectThree;

import java.time.LocalDate;


public class Voting {


    private User user;

    private Candidate candidate;

    private LocalDate votingDate;



    public Voting(User user,
                  Candidate candidate) {


        this.user = user;

        this.candidate = candidate;

        this.votingDate = LocalDate.now();

    }

    public String toString() {


        return "User Name : "
                + user.getUsername()

                + "\nCandidate : "
                + candidate.getCandidateName()

                + "\nDate      : "
                + votingDate;

    }

}