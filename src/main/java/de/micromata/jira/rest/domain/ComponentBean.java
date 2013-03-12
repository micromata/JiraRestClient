package de.micromata.jira.rest.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 06.03.13
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
public class ComponentBean extends BaseBean {

    public String description = StringUtils.EMPTY;

    public boolean isAssigneeTypeValid = false;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAssigneeTypeValid() {
        return isAssigneeTypeValid;
    }

    public void setAssigneeTypeValid(boolean assigneeTypeValid) {
        isAssigneeTypeValid = assigneeTypeValid;
    }
}
