package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

/**
 * Created by cschulc on 09.02.2016.
 */
public class CustomFieldBean extends BaseBean {

    @Expose
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
