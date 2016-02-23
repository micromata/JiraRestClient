package de.micromata.jira.rest.core.domain.customFields;

/**
 * Created by cschulc on 22.02.16.
 */
public class CascadingValueBean extends CustomFieldBaseBean {

    private ValueBean value;

    public ValueBean getValue() {
        return value;
    }

    public void setValue(ValueBean value) {
        this.value = value;
    }
}
