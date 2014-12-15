package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class ResolutionBean {

    @Expose
    private String self;
    @Expose
    private String id;
    @Expose
    private String description;
    @Expose
    private String name;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}