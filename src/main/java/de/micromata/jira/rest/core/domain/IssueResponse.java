package de.micromata.jira.rest.core.domain;

public class IssueResponse  {

    private String key;

    private Error error = null;

    public IssueResponse() {
        super();
    }

    public IssueResponse(Error error) {
        this.error = error;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
