package de.micromata.jira.rest.domain;

import java.net.URI;

public class PriorityBean extends BaseBean {

	private URI iconUrl = null;

	public URI getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(URI iconUrl) {
		this.iconUrl = iconUrl;
	}
}
