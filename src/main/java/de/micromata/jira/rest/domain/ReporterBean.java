package de.micromata.jira.rest.domain;

import org.apache.commons.lang3.StringUtils;

public class ReporterBean extends BaseBean {

	private String emailAddress = StringUtils.EMPTY;
	
	private AvatarURLBean avatarURLBean = null;
	
	private String displayName = StringUtils.EMPTY;
	
	private boolean active = false;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public AvatarURLBean getAvatarURLBean() {
		return avatarURLBean;
	}

	public void setAvatarURLBean(AvatarURLBean avatarURLBean) {
		this.avatarURLBean = avatarURLBean;
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
}
