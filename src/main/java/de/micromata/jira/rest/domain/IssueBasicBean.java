package de.micromata.jira.rest.domain;

public class IssueBasicBean extends BaseBean {

	private String key;
	
	private StatusBean statusBean;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public StatusBean getStatus() {
		return statusBean;
	}

	public void setStatus(StatusBean statusBean) {
		this.statusBean = statusBean;
	}
}
