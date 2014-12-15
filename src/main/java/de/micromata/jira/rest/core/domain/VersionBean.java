package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class VersionBean extends BaseBean{

    @Expose
    private Boolean archived;
    @Expose
    private String description;
    @Expose
    private String releaseDate;
    @Expose
    private Boolean released;

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
}
