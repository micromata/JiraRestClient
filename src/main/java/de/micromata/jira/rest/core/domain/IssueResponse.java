package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class IssueResponse  {

    @Expose
    private String key;
    @Expose
    private ErrorBean error = null;

    public IssueResponse() {
        super();
    }

    public IssueResponse(String key) {
        this.key = key;
    }

    public IssueResponse(ErrorBean error) {
        this.error = error;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }
}
