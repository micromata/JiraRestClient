package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

/**
 * Created by Christian on 09.12.2014.
 */
public class Transition {

    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private Status to;

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

    public Status getTo() {
        return to;
    }

    public void setTo(Status to) {
        this.to = to;
    }
}
