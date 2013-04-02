package de.micromata.jira.rest.domain;

import org.apache.commons.lang3.StringUtils;

public class VisibilityBean {

	private String type = StringUtils.EMPTY;
	
	private String value = StringUtils.EMPTY;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
