package de.micromata.jira.rest.util;

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
