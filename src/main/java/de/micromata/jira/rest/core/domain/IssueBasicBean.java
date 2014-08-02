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

import org.apache.commons.lang3.StringUtils;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class IssueBasicBean extends BaseBean {

    private String key = StringUtils.EMPTY;

    private String summary = StringUtils.EMPTY;

    private PriorityBean priorityBean = null;

    private StatusBean statusBean = null;

    private IssueTypeBean issueTypeBean = null;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public PriorityBean getPriority() {
        return priorityBean;
    }

    public void setPriority(PriorityBean priorityBean) {
        this.priorityBean = priorityBean;
    }

    public StatusBean getStatus() {
        return statusBean;
    }

    public void setStatus(StatusBean statusBean) {
        this.statusBean = statusBean;
    }

    public IssueTypeBean getIssueType() {
        return issueTypeBean;
    }

    public void setIssueType(IssueTypeBean issueTypeBean) {
        this.issueTypeBean = issueTypeBean;
    }
}
