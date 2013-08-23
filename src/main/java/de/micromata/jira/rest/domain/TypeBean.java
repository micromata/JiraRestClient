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
public class TypeBean extends BaseBean {

	private String inward = StringUtils.EMPTY;
	
	private String outward = StringUtils.EMPTY;

	public String getInward() {
		return inward;
	}

	public void setInward(String inward) {
		this.inward = inward;
	}

	public String getOutward() {
		return outward;
	}

	public void setOutward(String outward) {
		this.outward = outward;
	}
}
