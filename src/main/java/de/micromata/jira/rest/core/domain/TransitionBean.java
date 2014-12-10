package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

/**
 * Created by Christian on 09.12.2014.
 */
public class TransitionBean {

    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private StatusBean to;

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

    public StatusBean getTo() {
        return to;
    }

    public void setTo(StatusBean to) {
        this.to = to;
    }
}
