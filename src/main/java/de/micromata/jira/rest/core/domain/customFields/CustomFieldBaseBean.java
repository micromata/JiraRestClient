package de.micromata.jira.rest.core.domain.customFields;

import de.micromata.jira.rest.core.domain.BaseBean;

/**
 * Created by cschulc on 22.02.16.
 */
public class CustomFieldBaseBean extends BaseBean {

    private CustomFieldType type;

    public CustomFieldType getType() {
        return type;
    }

    public void setType(CustomFieldType type) {
        this.type = type;
    }
}
