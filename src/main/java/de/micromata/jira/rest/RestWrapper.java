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

package de.micromata.jira.rest;


import java.io.InputStream;
import java.net.URI;
import java.util.List;

import de.micromata.jira.rest.domain.*;
import de.micromata.jira.rest.jql.JqlSearchBean;
import de.micromata.jira.rest.util.RestException;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public interface RestWrapper {

    /**
     * Create a new issue
     *
     * @param issue = the issue
     * @param jiraRestClient = = the connected client
     * @return the key of the created issue, or an empty string when creation failed
     * @throws RestException
     */
	public IssueResponse createIssue(IssueBean issue, JiraRestClient jiraRestClient) throws RestException;

    /**
     * Get Attachement as InputStream
     *
     * @param jiraRestClient = = the connected client
     * @param uri = the uri of the resource
     * @return
     * @throws RestException
     */
    public InputStream getAttachment(JiraRestClient jiraRestClient, URI uri) throws RestException;

    /**
     * Returns true if the worklog is successfully transfered to the Issue.
     * <p/>
     * <p>This method is for merging log time for an Issue.
     *
     * @param jiraRestClient = the connected client
     * @param issueKey       = the issue key
     * @param worklog        = the one which would be transfered
     * @return created state
     * @throws RestException
     */
    public boolean transferWorklogInIssue(JiraRestClient jiraRestClient, String issueKey,
                                          WorklogBean worklog) throws RestException;

    /**
     * Returns true if the transition update on an Issue success.
     *
     * @param jiraRestClient = the connected client
     * @param issueKey       = the issue key
     * @param transitionId   = the transition id
     * @return success state
     * @throws RestException
     */
    public boolean updateIssueTransitionByKey(JiraRestClient jiraRestClient, String issueKey, int transitionId) throws RestException;

    /**
     * Returns available transitions for an Issue in a map with transition id and properties.
     *
     * @param jiraRestClient = the connected client
     * @param issueKey       = the issue key
     * @return List of TransitionBean
     * @throws RestException
     */
    public List<TransitionBean> getIssueTransitionsByKey(JiraRestClient jiraRestClient, String issueKey) throws RestException;

    /**
     * Returns the logged in remote user.
     *
     * @param jiraRestClient = the connected client
     * @return logged in user
     * @throws RestException
     */
    public UserBean getLoggedInRemoteUser(JiraRestClient jiraRestClient) throws RestException;

    /**
     * Returns a list of all projects.
     *
     * @param jiraRestClient = the connected client
     * @return list of projects
     * @throws RestException
     */
    public List<BasicProjectBean> getAllProjects(JiraRestClient jiraRestClient) throws RestException;

    /**
     * Returns a full representation of the project for the given key.
     *
     * @param jiraRestClient = the connected client
     * @param projectKey     = the project key
     * @return all informations for the project
     * @throws RestException
     */
    public ProjectBean getProjectByKey(JiraRestClient jiraRestClient, String projectKey) throws RestException;

    /**
     * Returns a list of all issues for the given project.
     *
     * @param jiraRestClient = the connected client
     * @param projectKey     = the project key
     * @return JQL search results
     * @throws RestException
     */
    public JqlSearchResultBean getIssuesForProject(JiraRestClient jiraRestClient, String projectKey) throws RestException;

    /**
     * Performs an extended search for issues given by the project.
     *
     * @param jiraRestClient = the connected client
     * @return list of issues
     * @throws RestException
     */
    public JqlSearchResultBean searchIssuesForProject(JiraRestClient jiraRestClient, JqlSearchBean jsb) throws RestException;

    /**
     * Returns a full representation of the issue for the given issue key.
     *
     * @param jiraRestClient = the connected client
     * @param issueKey       = issue key
     * @return all informations for the issue
     * @throws RestException
     */
    public IssueBean getIssueByKey(JiraRestClient jiraRestClient, String issueKey) throws RestException;


    /**
     * Returns a full representation of the issue for the given issue key.
     * Inklusive the RenderedField, if you need the Description of the Issue as HTML
     *
     * @param jiraRestClient = the connected client
     * @param issueKey       = issue key
     * @return all informations for the issue
     * @throws RestException
     */
    public IssueBean getIssueByKeyWithRenderedField(JiraRestClient jiraRestClient, String issueKey) throws RestException;

    /**
     * Test the REST connection with login data.
     *
     * @param uri      = the URI for the server where JIRA is running
     * @param username = login name
     * @param password = login password
     * @return true if the connection success
     * @throws RestException
     */
    public boolean testRestConnection(URI uri, String username, String password) throws RestException;

    /**
     * Returns a summarized representation of all comments for the given issue.
     *
     * @param jiraRestClient = the connected client
     * @param issueKey       = issue key
     * @return summarized representation of all comments
     * @throws RestException
     */
    public CommentSummaryBean getCommentsByIssue(JiraRestClient jiraRestClient,
                                                 String issueKey) throws RestException;

    /**
     * Returns a list of all versions for a project.
     *
     * @param jiraRestClient = the connected client
     * @param projectKey     = the project key
     * @return list of versions
     * @throws RestException
     */
    public List<VersionBean> getProjectVersions(JiraRestClient jiraRestClient,
                                                String projectKey) throws RestException;

    /**
     * Returns a list of all components for a project.
     *
     * @param jiraRestClient = the connected client
     * @param projectKey     = the project key
     * @return list of components
     * @throws RestException
     */
    public List<ComponentBean> getProjectComponents(JiraRestClient jiraRestClient,
                                                    String projectKey) throws RestException;

    /**
     * Returns a list of all issue types visible to the connected client.
     *
     * @param jiraRestClient = the connected client
     * @return list of issue types
     * @throws RestException
     */
    public List<IssueTypeBean> getIssueTypes(JiraRestClient jiraRestClient) throws RestException;

    /**
     * Returns a list of all statuses.
     *
     * @param jiraRestClient = the connected client
     * @return list of statuses
     * @throws RestException
     */
    public List<StatusBean> getStates(JiraRestClient jiraRestClient) throws RestException;


    /**
     * Returns a List of all Priority Object from the Remote Jira.
     *
     * @param jiraRestClient
     * @return
     * @throws RestException
     */
    public List<PriorityBean> getPriorities(JiraRestClient jiraRestClient) throws RestException;

}
