/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;

import org.apache.commons.lang3.StringUtils;
/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
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

	@Override
	public String toString() {
		return "VisibilityBean [type=" + type + ", value=" + value + "]";
	}
}
