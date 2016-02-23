package de.micromata.jira.rest.core.domain.customFields;

/**
 * Created by cschulc on 22.02.16.
 */
public class CustomFieldBaseBean {

    private CustomFieldType type;

    public CustomFieldType getType() {
        return type;
    }

    public void setType(CustomFieldType type) {
        this.type = type;
    }
}
