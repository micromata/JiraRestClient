/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;


import org.apache.commons.lang3.StringUtils;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class UserBean extends BaseBean {

    private AvatarURLBean avatarUrl = null;

    private String displayName = StringUtils.EMPTY;

    private boolean active = true;
    
    private String emailAddress = StringUtils.EMPTY;

    public AvatarURLBean getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(AvatarURLBean avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "UserBean [avatarUrl=" + avatarUrl + ", displayName="
				+ displayName + ", active=" + active + ", emailAddress="
				+ emailAddress + "]";
	}
}
