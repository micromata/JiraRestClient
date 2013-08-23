/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class CommentSummaryBean {
	
	private int startAt;
	
	private int maxResults;
	
	private int total;
	
	private List<CommentBean> comments;

	public int getStartAt() {
		return startAt;
	}

	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<CommentBean> getComments() {
        if(comments == null){
            comments = new ArrayList<CommentBean>();
        }
		return comments;
	}

	public void setComments(List<CommentBean> comments) {
		this.comments = comments;
	}
}
