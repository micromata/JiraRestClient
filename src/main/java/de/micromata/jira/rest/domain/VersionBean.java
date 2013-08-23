/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;



import java.util.Date;

import org.apache.commons.lang3.StringUtils;
/**
 * @author Christian Schulze
 * @author Vitali Filippow
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
