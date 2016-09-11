package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;
import de.micromata.jira.rest.core.domain.system.AssigneeTypeEnum;

import java.util.List;

public class ProjectBean extends BaseBean {

    @Expose
    private AvatarUrlsBean avatarUrls;
    @Expose
    private String key;
    @Expose
    private List<ComponentBean> components;
    @Expose
    private List<VersionBean> versions;
    @Expose
    private List<IssuetypeBean> issueTypes;
    @Expose
    private AssigneeTypeEnum assigneeType;

    public AvatarUrlsBean getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(AvatarUrlsBean avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public AssigneeTypeEnum getAssigneeType() {
        return assigneeType;
    }

    public void setAssigneeType(AssigneeTypeEnum assigneeType) {
        this.assigneeType = assigneeType;
    }
}
