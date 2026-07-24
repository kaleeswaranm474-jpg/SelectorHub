package ProjectThree;

import java.time.LocalDate;

public class Voting {

    private User user;
    private Candidate candidate;
    private LocalDate votingDate;

    // Constructor

    public Voting(User user,
                  Candidate candidate) {

        this.user = user;
        this.candidate = candidate;
        this.votingDate = LocalDate.now();
    }

    @Override
    public String toString() {

        return "\n========== VOTING DETAILS ==========" +
               "\nVoter ID       : " + user.getVoterId() +
               "\nVoter Name     : " + user.getUserName() +
               "\nCandidate      : " + candidate.getCandidateName() +
               "\nParty          : " + candidate.getPartyName() +
               "\nVoting Date    : " + votingDate;
    }
}