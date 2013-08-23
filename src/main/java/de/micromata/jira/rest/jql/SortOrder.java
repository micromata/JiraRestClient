/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.jql;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public enum SortOrder {

	ASC("asc"), DESC("desc");
	
	private String order;
	
	private SortOrder(String order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return this.order;
	}
}
