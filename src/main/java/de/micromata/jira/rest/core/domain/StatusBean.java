package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class StatusBean extends BaseBean{

    @Expose
    private String description;
    @Expose
    private String iconUrl;
    @Expose
    private StatusCategoryBean statusCategory;

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

    public StatusCategoryBean getStatusCategory() {
        return statusCategory;
    }

    public void setStatusCategory(StatusCategoryBean statusCategory) {
        this.statusCategory = statusCategory;
    }
}
