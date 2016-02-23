package de.micromata.jira.rest.core.domain.customFields;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by cschulc on 19.02.16.
 */
public enum CustomFieldType {
    // String Value Custom Fields
    URL("com.atlassian.jira.plugin.system.customfieldtypes:url"),
    DATE("com.atlassian.jira.plugin.system.customfieldtypes:datepicker"),
    DATETIME("com.atlassian.jira.plugin.system.customfieldtypes:datetime"),
    TEXT("com.atlassian.jira.plugin.system.customfieldtypes:textfield"),
    TEXTAREA("com.atlassian.jira.plugin.system.customfieldtypes:textarea"),
    FLOAT("com.atlassian.jira.plugin.system.customfieldtypes:float"),
    // Single ValueBean Custom Fields
    SELECT("com.atlassian.jira.plugin.system.customfieldtypes:select"),
    RADIO("com.atlassian.jira.plugin.system.customfieldtypes:radiobuttons"),
    // Multi ValueBean Custom Fields
    MULTISELECT("com.atlassian.jira.plugin.system.customfieldtypes:multiselect"),
    CHECKBOX("com.atlassian.jira.plugin.system.customfieldtypes:multicheckboxes"),
    LABELS("com.atlassian.jira.plugin.system.customfieldtypes:labels"),
    CASCADING("com.atlassian.jira.plugin.system.customfieldtypes:cascadingselect"),
    USER("com.atlassian.jira.plugin.system.customfieldtypes:userpicker"),
    MULTIUSER("com.atlassian.jira.plugin.system.customfieldtypes:multiuserpicker"),
    PROJECT("com.atlassian.jira.plugin.system.customfieldtypes:project"),
    VERSION("com.atlassian.jira.plugin.system.customfieldtypes:version"),
    MULTIVERSION("com.atlassian.jira.plugin.system.customfieldtypes:multiversion"),
    GROUP("com.atlassian.jira.plugin.system.customfieldtypes:grouppicker"),
    MULTIGROUP("com.atlassian.jira.plugin.system.customfieldtypes:multigrouppicker");


    CustomFieldType(String jiraName) {
        this.jiraName = jiraName;
    }

    public String jiraName = StringUtils.EMPTY;

    public String getJiraName() {
        return jiraName;
    }

}
