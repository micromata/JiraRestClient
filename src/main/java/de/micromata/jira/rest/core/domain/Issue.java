package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class Issue {

    @Expose
    private String expand;
    @Expose
    private Fields fields;
    @Expose
    private String id;
    @Expose
    private String key;
    @Expose
    private String self;

    public String getExpand() {
        return expand;
    }


    public void setExpand(String expand) {
        this.expand = expand;
    }

    public Fields getFields() {
        return fields;
    }


    public void setFields(Fields fields) {
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

}
