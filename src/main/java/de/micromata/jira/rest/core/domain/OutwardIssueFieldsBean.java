package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class OutwardIssueFieldsBean {

    @Expose
    private String summary;
    @Expose
    private StatusBean status;
    @Expose
    private PriorityBean priority;
    @Expose
    private IssuetypeBean issuetype;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public PriorityBean getPriority() {
        return priority;
    }

    public void setPriority(PriorityBean priority) {
        this.priority = priority;
    }

    public IssuetypeBean getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(IssuetypeBean issuetype) {
        this.issuetype = issuetype;
    }
}
