package de.micromata.jira.rest.domain;

import java.net.URI;

import org.apache.commons.lang3.StringUtils;

public class TransitionBean extends BaseBean {

	private String description = StringUtils.EMPTY;
	
	private URI iconUrl = null;
	
	private TransitionBean to = null;
	
	private boolean assigneeRequired = Boolean.FALSE;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public URI getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(URI iconUrl) {
		this.iconUrl = iconUrl;
	}

	public TransitionBean getTo() {
		return to;
	}

	public void setTo(TransitionBean to) {
		this.to = to;
	}

	public boolean isAssigneeRequired() {
		return assigneeRequired;
	}

	public void setAssigneeRequired(boolean assigneeRequired) {
		this.assigneeRequired = assigneeRequired;
	}
}
