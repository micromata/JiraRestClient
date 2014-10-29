package de.micromata.jira.rest.core.domain.update;

import org.apache.commons.lang3.StringUtils;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 29.10.2014
 */
public enum Operation {
    SET("set"),EDIT("edit"),REMOVE("remove");

    private String name = StringUtils.EMPTY;

    Operation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
