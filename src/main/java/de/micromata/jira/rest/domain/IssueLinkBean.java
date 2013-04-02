package de.micromata.jira.rest.domain;

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
