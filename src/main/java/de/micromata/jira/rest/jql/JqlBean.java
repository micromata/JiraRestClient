package de.micromata.jira.rest.jql;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * User: Christian
 * Date: 11.03.13
 * Time: 14:24
 */
public class JqlBean {

    private String searchTerm = StringUtils.EMPTY;

    private Integer startAt = null;

    private Integer maxResult = null;

    private String projectKey = StringUtils.EMPTY;

    private String issueType = StringUtils.EMPTY;

    private String status = StringUtils.EMPTY;

    private List<String> fields = null;

    private List<String> components = null;

    private List<String> affectedVersions = null;

    private List<String> fixVersions = null;


    public void addField(String ... fieldName){
        for (String s : fieldName) {
            getFields().add(s);
        }
    }


    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getFields() {
        if(fields == null){
            fields = new ArrayList<String>();
        }
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public Integer getStartAt() {
        return startAt;
    }

    public void setStartAt(Integer startAt) {
        this.startAt = startAt;
    }

    public Integer getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(Integer maxResult) {
        this.maxResult = maxResult;
    }

    public List<String> getComponents() {
        if(components == null){
            components = new ArrayList<String>();
        }
        return components;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }

    public List<String> getAffectedVersions() {
        if(affectedVersions == null){
            affectedVersions = new ArrayList<String>();
        }
        return affectedVersions;
    }

    public void setAffectedVersions(List<String> affectedVersions) {
        this.affectedVersions = affectedVersions;
    }

    public List<String> getFixVersions() {
        if(fixVersions == null){
            fixVersions = new ArrayList<String>();
        }
        return fixVersions;
    }

    public void setFixVersions(List<String> fixVersions) {
        this.fixVersions = fixVersions;
    }
}
