package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;


public class Watches {

    @Expose
    private Boolean isWatching;
    @Expose
    private String self;
    @Expose
    private Integer watchCount;

    public Boolean getIsWatching() {
        return isWatching;
    }

    public void setIsWatching(Boolean isWatching) {
        this.isWatching = isWatching;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public Integer getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(Integer watchCount) {
        this.watchCount = watchCount;
    }
}
