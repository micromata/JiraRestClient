package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;


public class ErrorsBean {

    @Expose
    private String project;
    @Expose
    private String subtasks;
    @Expose
    private String attachment;
    @Expose
    private String issuelinks;
    @Expose
    private String issuetype;
    @Expose
    private String reporter;
    @Expose
    private String assignee;
    @Expose
    private String environment;


    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(String subtasks) {
        this.subtasks = subtasks;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getIssuelinks() {
        return issuelinks;
    }

    public void setIssuelinks(String issuelinks) {
        this.issuelinks = issuelinks;
    }

    public String getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(String issuetype) {
        this.issuetype = issuetype;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
