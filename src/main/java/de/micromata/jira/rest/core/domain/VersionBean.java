package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class VersionBean extends BaseBean {

    @Expose
    private Boolean archived;
    @Expose
    private String description;
    @Expose
    private String releaseDate;
    @Expose
    private Boolean released;
    @Expose
    private String userStartDate;
    @Expose
    private String userReleaseDate;
    @Expose
    private Integer projectId;

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getReleased() {
        return released;
    }

    public void setReleased(Boolean released) {
        this.released = released;
    }

    public String getUserStartDate() {
        return userStartDate;
    }

    public void setUserStartDate(String userStartDate) {
        this.userStartDate = userStartDate;
    }

    public String getUserReleaseDate() {
        return userReleaseDate;
    }

    public void setUserReleaseDate(String userReleaseDate) {
        this.userReleaseDate = userReleaseDate;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
