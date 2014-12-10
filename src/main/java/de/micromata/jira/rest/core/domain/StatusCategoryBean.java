
package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;


public class StatusCategoryBean {

    @Expose
    private String colorName;
    @Expose
    private Integer id;
    @Expose
    private String key;
    @Expose
    private String name;
    @Expose
    private String self;

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
