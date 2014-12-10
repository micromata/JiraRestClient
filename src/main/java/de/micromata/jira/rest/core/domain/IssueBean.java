package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class IssueBean {

    @Expose
    private String expand;
    @Expose
    private FieldsBean fields;
    @Expose
    private String id;
    @Expose
    private String key;
    @Expose
    private String self;
    @Expose
    private RenderedFieldsBean renderedFields;

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public FieldsBean getFields() {
        return fields;
    }

    public void setFields(FieldsBean fields) {
        this.fields = fields;
    }

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

    public RenderedFieldsBean getRenderedFields() {
        return renderedFields;
    }

    public void setRenderedFields(RenderedFieldsBean renderedFields) {
        this.renderedFields = renderedFields;
    }
}
