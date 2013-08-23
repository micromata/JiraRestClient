/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;

import java.util.List;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class WorklogSummaryBean {

	private int startAt = 0;
	
	private int maxResults = 0;
	
	private int total = 0;
	
	private List<WorklogBean> worklogs = null;

	public int getStartAt() {
		return startAt;
	}

	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<WorklogBean> getWorklogs() {
		return worklogs;
	}

	public void setWorklogs(List<WorklogBean> worklogs) {
		this.worklogs = worklogs;
	}

	@Override
	public String toString() {
		return "WorklogSummaryBean [startAt=" + startAt + ", maxResults="
				+ maxResults + ", total=" + total + ", worklogs=" + worklogs
				+ "]";
	}
}
