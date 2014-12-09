
package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class Project {

    @Expose
    private AvatarUrls avatarUrls;
    @Expose
    private String id;
    @Expose
    private String key;
    @Expose
    private String name;
    @Expose
    private String self;

    public AvatarUrls getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(AvatarUrls avatarUrls) {
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
}
