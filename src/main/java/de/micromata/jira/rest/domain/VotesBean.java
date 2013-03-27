package de.micromata.jira.rest.domain;


public class VotesBean extends BaseBean {

	private int votes;
	
	private boolean hasVoted = false;

	public int getVoted() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public boolean isHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}
}
