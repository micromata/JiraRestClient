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

import java.util.Date;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
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
