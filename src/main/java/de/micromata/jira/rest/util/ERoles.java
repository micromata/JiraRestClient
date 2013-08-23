/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.util;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public enum ERoles implements JsonConstants {

	ADMINISTRATORS(ROLE_ADMINISTRATORS),
	USERS(ROLE_USERS),
	DEVELOPERS(ROLE_DEVELOPERS);
	
	private final String name;
	
	private ERoles(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
