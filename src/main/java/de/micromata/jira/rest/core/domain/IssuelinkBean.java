package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class IssuelinkBean {

    @Expose
    private String id;
    @Expose
    private String self;
    @Expose
    private TypeBean type;
    @Expose
    private OutwardIssueBean outwardIssue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public TypeBean getType() {
        return type;
    }

    public void setType(TypeBean type) {
        this.type = type;
    }

    public OutwardIssueBean getOutwardIssue() {
        return outwardIssue;
    }

    public void setOutwardIssue(OutwardIssueBean outwardIssue) {
        this.outwardIssue = outwardIssue;
    }
}
