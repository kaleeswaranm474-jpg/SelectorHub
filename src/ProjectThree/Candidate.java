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

    // Getters

    public int getCandidateId() {
        return candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getPartyName() {
        return partyName;
    }

    public int getVotes() {
        return votes;
    }

    // Increase Vote Count

    public void addVote() {
        votes++;
    }

    @Override
    public String toString() {

        return "\n========== CANDIDATE DETAILS ==========" +
               "\nCandidate ID   : " + candidateId +
               "\nCandidate Name : " + candidateName +
               "\nParty Name     : " + partyName +
               "\nTotal Votes    : " + votes;
    }
}