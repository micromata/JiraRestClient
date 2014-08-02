package de.micromata.jira.rest.core.domain;

import java.util.Date;
import java.util.List;

public class IssueHistoryBean extends BaseBean {

	private UserBean author = null;
	
	private Date created = null;
	
	private List<HistoryItemBean> items = null;

	public UserBean getAuthor() {
		return author;
	}

	public void setAuthor(UserBean author) {
		this.author = author;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public List<HistoryItemBean> getItems() {
		return items;
	}

	public void setItems(List<HistoryItemBean> items) {
		this.items = items;
	}
}
