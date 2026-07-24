package ProjectThree;

public class Candidate {


    private int candidateId;

    private String candidateName;

    private String partyName;

    private int votes;

    // Constructor

    public Candidate(int candidateId,
                     String candidateName,
                     String partyName) {


        this.candidateId = candidateId;

        this.candidateName = candidateName;

        this.partyName = partyName;

        this.votes = 0;

    }

    // Getter Methods


    public int getCandidateId() {

        return candidateId;
    }



    public String getCandidateName() {

        return candidateName;
    }

    public int getVotes() {

        return votes;
    }


    // Increase Vote

    public void addVote() {

        votes++;

    }


    public String toString() {


        return "Candidate ID : " + candidateId +
               "\nName          : " + candidateName +
               "\nParty         : " + partyName +
               "\nVotes         : " + votes;

    }

}