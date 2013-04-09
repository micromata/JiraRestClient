package de.micromata.jira.rest.domain;

import java.net.URI;

import org.apache.commons.lang3.StringUtils;

/**
 * User: Christian
 * Date: 12.03.13
 * Time: 17:05
 */
public class StatusBean extends BaseBean {

    private String description = StringUtils.EMPTY;

    private URI iconUrl = null;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URI getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(URI iconUrl) {
        this.iconUrl = iconUrl;
    }
}
