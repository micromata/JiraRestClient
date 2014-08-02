/*
 * Copyright 2013 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.micromata.jira.rest.core.domain;


import org.apache.commons.lang3.StringUtils;

import java.util.Date;

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
