package de.micromata.jira.rest.domain;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import de.micromata.jira.rest.util.ERoles;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 06.03.13
 * Time: 13:35
 * To change this template use File | Settings | File Templates.
 */
public class ProjectBean extends BasicProjectBean {

    private String description = StringUtils.EMPTY;

    private UserBean lead = null;

    private List<ComponentBean> components = null;

    private List<VersionBean> versions = null;

    private List<IssueTypeBean> issueTypes = null;

    private String assigneeType = StringUtils.EMPTY;
    
    private Map<ERoles, URI> roles = null;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserBean getLead() {
        return lead;
    }

    public void setLead(UserBean lead) {
        this.lead = lead;
    }

    public List<ComponentBean> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentBean> components) {
        this.components = components;
    }

    public List<VersionBean> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionBean> versions) {
        this.versions = versions;
    }

    public List<IssueTypeBean> getIssueTypes() {
        return issueTypes;
    }

    public void setIssueTypes(List<IssueTypeBean> issueTypes) {
        this.issueTypes = issueTypes;
    }

    public String getAssigneeType() {
        return assigneeType;
    }

    public void setAssigneeType(String assigneeType) {
        this.assigneeType = assigneeType;
    }

	public Map<ERoles, URI> getRoles() {
		return roles;
	}

	public void setRoles(Map<ERoles, URI> roles) {
		this.roles = roles;
	}
}
