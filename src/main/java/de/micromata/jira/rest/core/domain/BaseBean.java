package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

/**
 * Created by Christian on 12.12.2014.
 */
public class BaseBean implements Comparable<BaseBean> {

    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private String self;

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

    @Override
    public int compareTo(BaseBean o) {
        return this.name.compareTo(o.getName());
    }

}
