/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;

import org.apache.commons.lang3.StringUtils;
/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class IssueBasicBean extends BaseBean {

	private String key = StringUtils.EMPTY;
	
	private String summary = StringUtils.EMPTY;
	
	private PriorityBean priorityBean = null;
	
	private StatusBean statusBean = null;
	
	private IssueTypeBean issueTypeBean = null;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public PriorityBean getPriority() {
		return priorityBean;
	}

	public void setPriority(PriorityBean priorityBean) {
		this.priorityBean = priorityBean;
	}

	public StatusBean getStatus() {
		return statusBean;
	}

	public void setStatus(StatusBean statusBean) {
		this.statusBean = statusBean;
	}

	public IssueTypeBean getIssueType() {
		return issueTypeBean;
	}

	public void setIssueType(IssueTypeBean issueTypeBean) {
		this.issueTypeBean = issueTypeBean;
	}
}
