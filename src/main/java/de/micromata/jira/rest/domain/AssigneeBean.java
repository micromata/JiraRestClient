package de.micromata.jira.rest.domain;

public class AssigneeBean extends BaseBean {

	private String emailAddress;
	
	private AvatarURLBean avatarURLBean;
	
	private String displayName;
	
	private boolean active;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public AvatarURLBean getAvatarURL() {
		return avatarURLBean;
	}

	public void setAvatarURL(AvatarURLBean avatarURLBean) {
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
