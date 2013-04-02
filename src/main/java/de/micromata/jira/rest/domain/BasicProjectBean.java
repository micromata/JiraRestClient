package de.micromata.jira.rest.domain;


/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 01.03.13
 * Time: 11:50
 * To change this template use File | Settings | File Templates.
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
