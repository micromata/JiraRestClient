package de.micromata.jira.rest.domain;

import java.util.Date;

public class CommentBean extends BaseBean {

	private UserBean author;
	
	private String body;
	
	private UserBean updateAuthor;
	
	private Date created;
	
	private Date updated;
	
	private VisibilityBean visibility;

	public UserBean getAuthor() {
		return author;
	}

	public void setAuthor(UserBean author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public UserBean getUpdateAuthor() {
		return updateAuthor;
	}

	public void setUpdateAuthor(UserBean updateAuthor) {
		this.updateAuthor = updateAuthor;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public VisibilityBean getVisibility() {
		return visibility;
	}

	public void setVisibility(VisibilityBean visibility) {
		this.visibility = visibility;
	}

    @Override
    public int compareTo(BaseBean o) {
        CommentBean c = (CommentBean) o;
        return this.created.compareTo(c.created);
    }
}
