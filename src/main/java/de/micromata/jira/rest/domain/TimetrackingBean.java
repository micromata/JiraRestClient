package de.micromata.jira.rest.domain;

import org.apache.commons.lang3.StringUtils;

public class TimetrackingBean {

	private String originalEstimate = StringUtils.EMPTY;
	
	private String remainingEstimate = StringUtils.EMPTY;
	
	private String timeSpent = StringUtils.EMPTY;
	
	private int originalEstimateSeconds;
	
	private int remainingEstimateSeconds;
	
	private int timeSpentSeconds;

	public String getOriginalEstimate() {
		return originalEstimate;
	}

	public void setOriginalEstimate(String originalEstimate) {
		this.originalEstimate = originalEstimate;
	}

	public String getRemainingEstimate() {
		return remainingEstimate;
	}

	public void setRemainingEstimate(String remainingEstimate) {
		this.remainingEstimate = remainingEstimate;
	}

	public String getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(String timeSpent) {
		this.timeSpent = timeSpent;
	}

	public int getOriginalEstimateSeconds() {
		return originalEstimateSeconds;
	}

	public void setOriginalEstimateSeconds(int originalEstimateSeconds) {
		this.originalEstimateSeconds = originalEstimateSeconds;
	}

	public int getRemainingEstimateSeconds() {
		return remainingEstimateSeconds;
	}

	public void setRemainingEstimateSeconds(int remainingEstimateSeconds) {
		this.remainingEstimateSeconds = remainingEstimateSeconds;
	}

	public int getTimeSpentSeconds() {
		return timeSpentSeconds;
	}

	public void setTimeSpentSeconds(int timeSpentSeconds) {
		this.timeSpentSeconds = timeSpentSeconds;
	}
}
