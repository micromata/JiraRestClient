package de.micromata.jira.rest.domain;

import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class RenderedFieldsBean {

    private String description = StringUtils.EMPTY;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
