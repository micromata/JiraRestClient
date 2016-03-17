package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

import java.util.List;

public class IssueBean extends BaseBean {

    @Expose
    private FieldsBean fields;
    @Expose
    private String key;
    @Expose
    private RenderedFieldsBean renderedFields;
    @Expose
    private List<TransitionBean> transitions;
    @Expose
    private Changelog changelog;

    public FieldsBean getFields() {
        return fields;
    }

    public void setFields(FieldsBean fields) {
        this.fields = fields;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public RenderedFieldsBean getRenderedFields() {
        return renderedFields;
    }

    public void setRenderedFields(RenderedFieldsBean renderedFields) {
        this.renderedFields = renderedFields;
    }

    public List<TransitionBean> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<TransitionBean> transitions) {
        this.transitions = transitions;
    }

    public Changelog getChangelog() {
        return changelog;
    }

    public void setChangelog(Changelog changelog) {
        this.changelog = changelog;
    }
}
