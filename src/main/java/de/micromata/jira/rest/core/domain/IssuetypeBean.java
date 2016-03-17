package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class IssuetypeBean extends BaseBean {

    @Expose
    private String description;
    @Expose
    private String iconUrl;
    @Expose
    private Boolean subtask;
    @Expose
    private Integer avatarId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Boolean getSubtask() {
        return subtask;
    }

    public void setSubtask(Boolean subtask) {
        this.subtask = subtask;
    }

    public Integer getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
    }
}
