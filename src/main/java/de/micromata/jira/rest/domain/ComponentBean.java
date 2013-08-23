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
public class ComponentBean extends BaseBean {

    private String description = StringUtils.EMPTY;
    
    private UserBean lead = null;

    private boolean isAssigneeTypeValid = false;
    
    private String assigneeType = StringUtils.EMPTY;
    
    private UserBean assignee = null;

    private String realAssigneeType = StringUtils.EMPTY;
    
    private UserBean realAssignee = null;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAssigneeTypeValid() {
        return isAssigneeTypeValid;
    }

    public void setAssigneeTypeValid(boolean assigneeTypeValid) {
        isAssigneeTypeValid = assigneeTypeValid;
    }

	public UserBean getLead() {
		return lead;
	}

	public void setLead(UserBean lead) {
		this.lead = lead;
	}

	public String getAssigneeType() {
		return assigneeType;
	}

	public void setAssigneeType(String assigneeType) {
		this.assigneeType = assigneeType;
	}

	public UserBean getAssignee() {
		return assignee;
	}

	public void setAssignee(UserBean assignee) {
		this.assignee = assignee;
	}

	public String getRealAssigneeType() {
		return realAssigneeType;
	}

	public void setRealAssigneeType(String realAssigneeType) {
		this.realAssigneeType = realAssigneeType;
	}

	public UserBean getRealAssignee() {
		return realAssignee;
	}

	public void setRealAssignee(UserBean realAssignee) {
		this.realAssignee = realAssignee;
	}
}
