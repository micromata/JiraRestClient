package de.micromata.jira.rest.domain;

import org.apache.commons.lang3.StringUtils;

public class TimetrackingBean {

	private String originalEstimate = StringUtils.EMPTY;
	
	private String remainingEstimate = StringUtils.EMPTY;
	
	private String timeSpent = StringUtils.EMPTY;
	
	private Long originalEstimateSeconds = null;
	
	private Long remainingEstimateSeconds = null;
	
	private Long timeSpentSeconds = null;

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

	public Long getOriginalEstimateSeconds() {
		return originalEstimateSeconds;
	}

	public void setOriginalEstimateSeconds(Long originalEstimateSeconds) {
		this.originalEstimateSeconds = originalEstimateSeconds;
	}

	public Long getRemainingEstimateSeconds() {
		return remainingEstimateSeconds;
	}

	public void setRemainingEstimateSeconds(Long remainingEstimateSeconds) {
		this.remainingEstimateSeconds = remainingEstimateSeconds;
	}

	public Long getTimeSpentSeconds() {
		return timeSpentSeconds;
	}

	public void setTimeSpentSeconds(Long timeSpentSeconds) {
		this.timeSpentSeconds = timeSpentSeconds;
	}
}
