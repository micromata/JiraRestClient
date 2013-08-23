/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;

import java.net.URI;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class BaseBean implements Comparable<BaseBean> {

    protected long id;

    protected URI self;

    protected String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public URI getSelf() {
        return self;
    }

    public void setSelf(URI self) {
        this.self = self;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(BaseBean o) {
        return this.name.compareTo(o.getName());
    }
}
