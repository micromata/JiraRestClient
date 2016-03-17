package de.micromata.jira.rest.core.domain.meta;

import com.google.gson.annotations.Expose;
import de.micromata.jira.rest.core.domain.meta.fields.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cschulc on 16.03.16.
 */
public class FieldsMetaBean {

    @Expose
    private IssueTypeFieldMetaBean issuetype;

    @Expose
    private ComponentFieldMetaBean components;

    @Expose
    private FieldMetaBean description;

    @Expose
    private ProjectFieldMetaBean project;

    @Expose
    private VersionsFieldMetaBean fixVersions;

    @Expose
    private FieldMetaBean timetracking;

    @Expose
    private FieldMetaBean attachment;

    @Expose
    private FieldMetaBean summary;

    @Expose
    private FieldMetaBean reporter;

    @Expose
    private PriorityFieldMetaBean priority;

    @Expose
    private FieldMetaBean labels;

    @Expose
    private FieldMetaBean environment;

    @Expose
    private VersionsFieldMetaBean versions;

    @Expose
    private FieldMetaBean duedate;

    @Expose
    private FieldMetaBean assignee;

    private List<FieldMetaBean> custom = new ArrayList<>();

    public IssueTypeFieldMetaBean getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(IssueTypeFieldMetaBean issuetype) {
        this.issuetype = issuetype;
    }

    public ComponentFieldMetaBean getComponents() {
        return components;
    }

    public void setComponents(ComponentFieldMetaBean components) {
        this.components = components;
    }

    public FieldMetaBean getDescription() {
        return description;
    }

    public void setDescription(FieldMetaBean description) {
        this.description = description;
    }

    public ProjectFieldMetaBean getProject() {
        return project;
    }

    public void setProject(ProjectFieldMetaBean project) {
        this.project = project;
    }

    public VersionsFieldMetaBean getFixVersions() {
        return fixVersions;
    }

    public void setFixVersions(VersionsFieldMetaBean fixVersions) {
        this.fixVersions = fixVersions;
    }

    public FieldMetaBean getTimetracking() {
        return timetracking;
    }

    public void setTimetracking(FieldMetaBean timetracking) {
        this.timetracking = timetracking;
    }

    public FieldMetaBean getAttachment() {
        return attachment;
    }

    public void setAttachment(FieldMetaBean attachment) {
        this.attachment = attachment;
    }

    public FieldMetaBean getSummary() {
        return summary;
    }

    public void setSummary(FieldMetaBean summary) {
        this.summary = summary;
    }

    public FieldMetaBean getReporter() {
        return reporter;
    }

    public void setReporter(FieldMetaBean reporter) {
        this.reporter = reporter;
    }

    public PriorityFieldMetaBean getPriority() {
        return priority;
    }

    public void setPriority(PriorityFieldMetaBean priority) {
        this.priority = priority;
    }

    public FieldMetaBean getLabels() {
        return labels;
    }

    public void setLabels(FieldMetaBean labels) {
        this.labels = labels;
    }

    public FieldMetaBean getEnvironment() {
        return environment;
    }

    public void setEnvironment(FieldMetaBean environment) {
        this.environment = environment;
    }

    public VersionsFieldMetaBean getVersions() {
        return versions;
    }

    public void setVersions(VersionsFieldMetaBean versions) {
        this.versions = versions;
    }

    public FieldMetaBean getDuedate() {
        return duedate;
    }

    public void setDuedate(FieldMetaBean duedate) {
        this.duedate = duedate;
    }

    public FieldMetaBean getAssignee() {
        return assignee;
    }

    public void setAssignee(FieldMetaBean assignee) {
        this.assignee = assignee;
    }

    public List<FieldMetaBean> getCustom() {
        return custom;
    }

    public void setCustom(List<FieldMetaBean> custom) {
        this.custom = custom;
    }
}
