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

import de.micromata.jira.rest.core.util.ERoles;
import org.apache.commons.lang3.StringUtils;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class ProjectBean extends BasicProjectBean {

    private String description = StringUtils.EMPTY;

    private UserBean lead = null;

    private List<ComponentBean> components = null;

    private List<VersionBean> versions = null;

    private List<IssueTypeBean> issueTypes = null;

    private String assigneeType = StringUtils.EMPTY;

    private Map<ERoles, URI> roles = null;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserBean getLead() {
        return lead;
    }

    public void setLead(UserBean lead) {
        this.lead = lead;
    }

    public List<ComponentBean> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentBean> components) {
        this.components = components;
    }

    public List<VersionBean> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionBean> versions) {
        this.versions = versions;
    }

    public List<IssueTypeBean> getIssueTypes() {
        return issueTypes;
    }

    public void setIssueTypes(List<IssueTypeBean> issueTypes) {
        this.issueTypes = issueTypes;
    }

    public String getAssigneeType() {
        return assigneeType;
    }

    public void setAssigneeType(String assigneeType) {
        this.assigneeType = assigneeType;
    }

    public Map<ERoles, URI> getRoles() {
        return roles;
    }

    public void setRoles(Map<ERoles, URI> roles) {
        this.roles = roles;
    }
}
