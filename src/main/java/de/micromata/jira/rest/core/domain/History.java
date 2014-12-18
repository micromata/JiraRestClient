
package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class History {

    @Expose
    private String id;
    @Expose
    private UserBean author;
    @Expose
    private String created;
    @Expose
    private List<Item> items = new ArrayList<Item>();

    public UserBean getAuthor() {
        return author;
    }

    public void setAuthor(UserBean author) {
        this.author = author;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
