package de.micromata.jira.rest.domain;

import org.apache.commons.lang3.StringUtils;

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
