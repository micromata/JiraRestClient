
package de.micromata.jira.rest.core.domain2;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class UpdateAuthor {

    @Expose
    private Boolean active;
    @Expose
    private AvatarUrls___ avatarUrls;
    @Expose
    private String displayName;
    @Expose
    private String emailAddress;
    @Expose
    private String name;
    @Expose
    private String self;

    /**
     * 
     * @return
     *     The active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * 
     * @param active
     *     The active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * 
     * @return
     *     The avatarUrls
     */
    public AvatarUrls___ getAvatarUrls() {
        return avatarUrls;
    }

    /**
     * 
     * @param avatarUrls
     *     The avatarUrls
     */
    public void setAvatarUrls(AvatarUrls___ avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    /**
     * 
     * @return
     *     The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * @param displayName
     *     The displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 
     * @return
     *     The emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * 
     * @param emailAddress
     *     The emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The self
     */
    public String getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(String self) {
        this.self = self;
    }

}
