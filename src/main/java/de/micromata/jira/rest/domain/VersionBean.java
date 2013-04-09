package de.micromata.jira.rest.domain;



import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 06.03.13
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class VersionBean extends BaseBean {

    private String description = StringUtils.EMPTY;

    private boolean archived = false;

    private boolean released = false;

    private boolean overdue = false;

    private Date releaseDate = null;

    private Date userReleaseDate = null;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isReleased() {
        return released;
    }

    public void setReleased(boolean released) {
        this.released = released;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getUserReleaseDate() {
        return userReleaseDate;
    }

    public void setUserReleaseDate(Date userReleaseDate) {
        this.userReleaseDate = userReleaseDate;
    }
}
