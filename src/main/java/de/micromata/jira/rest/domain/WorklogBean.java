package de.micromata.jira.rest.domain;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class WorklogBean extends BaseBean {

	private UserBean author = null;
	
	private UserBean updateAuthor = null;
	
	private String comment = StringUtils.EMPTY;
	
	private VisibilityBean visibilityBean = null;
	
	private Date started = null;
	
	private String timeSpent = StringUtils.EMPTY;
	
	private long timeSpentSeconds = 0;

	public UserBean getAuthor() {
		return author;
	}

	public void setAuthor(UserBean author) {
		this.author = author;
	}

	public UserBean getUpdateAuthor() {
		return updateAuthor;
	}

	public void setUpdateAuthor(UserBean updateAuthor) {
		this.updateAuthor = updateAuthor;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public VisibilityBean getVisibility() {
		return visibilityBean;
	}

	public void setVisibility(VisibilityBean visibilityBean) {
		this.visibilityBean = visibilityBean;
	}

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public String getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(String timeSpent) {
		this.timeSpent = timeSpent;
	}

	public long getTimeSpentSeconds() {
		return timeSpentSeconds;
	}

	public void setTimeSpentSeconds(long timeSpentSeconds) {
		this.timeSpentSeconds = timeSpentSeconds;
	}
}
