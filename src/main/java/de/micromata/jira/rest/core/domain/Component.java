package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class Component {

    @Expose
    private String description;
    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private String self;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }
}
