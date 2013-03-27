package de.micromata.jira.rest.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 06.03.13
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
public class ComponentBean extends BaseBean {

    private String description = StringUtils.EMPTY;
    
    private UserBean lead = null;

    private boolean isAssigneeTypeValid = false;
    
    private String assigneeType = StringUtils.EMPTY;
    
    private AssigneeBean assignee = null;

    private String realAssigneeType = StringUtils.EMPTY;
    
    private AssigneeBean realAssignee = null;

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

	public AssigneeBean getAssignee() {
		return assignee;
	}

	public void setAssignee(AssigneeBean assignee) {
		this.assignee = assignee;
	}

	public String getRealAssigneeType() {
		return realAssigneeType;
	}

	public void setRealAssigneeType(String realAssigneeType) {
		this.realAssigneeType = realAssigneeType;
	}

	public AssigneeBean getRealAssignee() {
		return realAssignee;
	}

	public void setRealAssignee(AssigneeBean realAssignee) {
		this.realAssignee = realAssignee;
	}
}
