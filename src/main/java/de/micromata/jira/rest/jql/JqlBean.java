package de.micromata.jira.rest.jql;


import org.apache.commons.lang3.StringUtils;

/**
 * User: Christian
 * Date: 11.03.13
 * Time: 14:24
 */
public class JqlBean {


    private String projectKey = StringUtils.EMPTY;

    private String issueType = StringUtils.EMPTY;

    private String status = StringUtils.EMPTY;


    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
