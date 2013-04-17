package de.micromata.jira.rest.domain;

import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 09:55
 * To change this template use File | Settings | File Templates.
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
