package de.micromata.jira.rest.core.domain.field;

import com.google.gson.annotations.Expose;

/**
 * Created by Christian on 12.01.2015.
 */
public class CreateFieldBean {

    @Expose
    private String name;
    @Expose
    private String description;
    @Expose
    private String type;
    @Expose
    private String searcherKey;

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

    public String getSearcherKey() {
        return searcherKey;
    }

    public void setSearcherKey(String searcherKey) {
        this.searcherKey = searcherKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
