package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class IssuetypeBean {

    @Expose
    private String description;
    @Expose
    private String iconUrl;
    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private String self;
    @Expose
    private Boolean subtask;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
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

    public Boolean getSubtask() {
        return subtask;
    }

    public void setSubtask(Boolean subtask) {
        this.subtask = subtask;
    }
}
