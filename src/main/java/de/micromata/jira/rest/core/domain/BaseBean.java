package de.micromata.jira.rest.core.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

/**
 * Author: Christian
 * Date: 12.12.2014.
 */
public class BaseBean implements Comparable<BaseBean> {

    protected Gson gson = new GsonBuilder().create();

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

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
