/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class BasicProjectBean extends BaseBean {

    private  String key;

    private AvatarURLBean avatarURLs = null;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

	public AvatarURLBean getAvatarURLs() {
		return avatarURLs;
	}

	public void setAvatarURLs(AvatarURLBean avatarURLs) {
		this.avatarURLs = avatarURLs;
	}
}
