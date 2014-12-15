package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;


public class PriorityBean extends BaseBean {

    @Expose
    private String iconUrl;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

}
