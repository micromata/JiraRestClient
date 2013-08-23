/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;

import java.net.URI;
import java.util.Date;
/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class AttachmentBean extends BaseBean {

	private String fileName;
	
	private UserBean author;
	
	private Date created;
	
	private int size;
	
	private String mimeType;
	
	private URI content;
	
	private URI thumbnail;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public URI getContent() {
		return content;
	}

	public void setContent(URI content) {
		this.content = content;
	}

	public URI getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(URI thumbnail) {
		this.thumbnail = thumbnail;
	}
}
