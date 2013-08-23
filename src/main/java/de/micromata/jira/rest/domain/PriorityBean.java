/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;

import java.net.URI;
/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class PriorityBean extends BaseBean {

	private URI iconUrl = null;

	public URI getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(URI iconUrl) {
		this.iconUrl = iconUrl;
	}
}
