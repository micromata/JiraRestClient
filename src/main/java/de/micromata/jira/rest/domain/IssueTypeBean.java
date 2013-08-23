/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;

import java.net.URI;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class IssueTypeBean extends BaseBean {

    private String description = StringUtils.EMPTY;

    private URI iconURL = null;

    private boolean subtask = false;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URI getIconURL() {
        return iconURL;
    }

    public void setIconURL(URI iconURL) {
        this.iconURL = iconURL;
    }

    public boolean isSubtask() {
        return subtask;
    }

    public void setSubtask(boolean subtask) {
        this.subtask = subtask;
    }
}
