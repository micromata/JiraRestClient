package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class OutwardIssueBean {

    @Expose
    private String id;
    @Expose
    private String key;
    @Expose
    private String self;
    @Expose
    private OutwardIssueFieldsBean fields;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public OutwardIssueFieldsBean getFields() {
        return fields;
    }

    public void setFields(OutwardIssueFieldsBean fields) {
        this.fields = fields;
    }
}
