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
public class IssueLinkBean extends BaseBean {

	private TypeBean typeBean = null;
	
	private IssueBasicBean outwardIssueBean = null;
	
	private IssueBasicBean inwardIssueBean = null;

	public TypeBean getTypeBean() {
		return typeBean;
	}

	public void setTypeBean(TypeBean typeBean) {
		this.typeBean = typeBean;
	}

	public IssueBasicBean getOutwardIssue() {
		return outwardIssueBean;
	}

	public void setOutwardIssue(IssueBasicBean outwardIssueBean) {
		this.outwardIssueBean = outwardIssueBean;
	}

	public IssueBasicBean getInwardIssue() {
		return inwardIssueBean;
	}

	public void setInwardIssue(IssueBasicBean inwardIssueBean) {
		this.inwardIssueBean = inwardIssueBean;
	}
}
