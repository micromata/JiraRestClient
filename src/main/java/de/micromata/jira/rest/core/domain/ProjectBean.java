package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ProjectBean {

    @Expose
    private AvatarUrlsBean avatarUrls;
    @Expose
    private String id;
    @Expose
    private String key;
    @Expose
    private String name;
    @Expose
    private String self;
    @Expose
    private List<ComponentBean> components;
    @Expose
    private List<VersionBean> versions;
    @Expose
    private List<IssuetypeBean> issueTypes;

    public AvatarUrlsBean getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(AvatarUrlsBean avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public List<ComponentBean> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentBean> components) {
        this.components = components;
    }

    public List<VersionBean> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionBean> versions) {
        this.versions = versions;
    }

    public List<IssuetypeBean> getIssueTypes() {
        return issueTypes;
    }

    public void setIssueTypes(List<IssuetypeBean> issueTypes) {
        this.issueTypes = issueTypes;
    }
}
