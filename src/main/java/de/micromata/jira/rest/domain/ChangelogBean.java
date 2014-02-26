package de.micromata.jira.rest.domain;

import java.util.List;

public class ChangelogBean {

	private int startAt = 0;
	
	private int maxResults = 0;
	
	private int total = 0;
	
	private List<IssueHistoryBean> histories = null;

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

	public List<IssueHistoryBean> getHistories() {
		return histories;
	}

	public void setHistories(List<IssueHistoryBean> histories) {
		this.histories = histories;
	}
}
