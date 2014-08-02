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
public class WorklogBean extends BaseBean {

    private UserBean author = null;

    private UserBean updateAuthor = null;

    private String comment = StringUtils.EMPTY;

    private VisibilityBean visibilityBean = null;

    private Date started = null;

    private String timeSpent = StringUtils.EMPTY;

    private long timeSpentSeconds = 0;

    public UserBean getAuthor() {
        return author;
    }

    public void setAuthor(UserBean author) {
        this.author = author;
    }

    public UserBean getUpdateAuthor() {
        return updateAuthor;
    }

    public void setUpdateAuthor(UserBean updateAuthor) {
        this.updateAuthor = updateAuthor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public VisibilityBean getVisibility() {
        return visibilityBean;
    }

    public void setVisibility(VisibilityBean visibilityBean) {
        this.visibilityBean = visibilityBean;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    public long getTimeSpentSeconds() {
        return timeSpentSeconds;
    }

    public void setTimeSpentSeconds(long timeSpentSeconds) {
        this.timeSpentSeconds = timeSpentSeconds;
    }

    @Override
    public String toString() {
        return "WorklogBean [id=" + id + ", author=" + author + ", updateAuthor="
                + updateAuthor + ", comment=" + comment + ", visibilityBean="
                + visibilityBean + ", started=" + started + ", timeSpent="
                + timeSpent + ", timeSpentSeconds=" + timeSpentSeconds + "]";
    }
}
