/*
 * Copyright 2013 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.micromata.jira.rest.core.domain;

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

    private byte[] data;

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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
