package de.micromata.jira.rest.core.domain;

public class IssueResponse  {

    private String key;

    private Error errorBean = null;

    public IssueResponse() {
        super();
    }

    public IssueResponse(Error errorBean) {
        this.errorBean = errorBean;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Error getErrorBean() {
        return errorBean;
    }

    public void setErrorBean(Error errorBean) {
        this.errorBean = errorBean;
    }
}
