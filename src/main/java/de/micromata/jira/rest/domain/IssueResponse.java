package de.micromata.jira.rest.domain;

public class IssueResponse extends BaseBean {

    private String key;

    private ErrorBean errorBean = null;

    public IssueResponse() {
        super();
    }

    public IssueResponse(ErrorBean errorBean) {
        this.errorBean = errorBean;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ErrorBean getErrorBean() {
        return errorBean;
    }

    public void setErrorBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
    }
}
