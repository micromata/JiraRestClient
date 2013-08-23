/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
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
