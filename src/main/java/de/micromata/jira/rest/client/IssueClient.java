package de.micromata.jira.rest.client;

import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.core.domain.*;
import de.micromata.jira.rest.core.util.RestException;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

/**
 * The IssueClient provides all Informations for Jira Issues
 */
public interface IssueClient {
    /**
     * Create a new issue
     *
     * @param issue = the issue
     * @return IssueResponse
     * @throws de.micromata.jira.rest.core.util.RestException
     */
    public IssueResponse createIssue(IssueBean issue) throws RestException;

    /**
     * Returns a summarized representation of all comments for the given issue.
     *
     * @param issueKey = issue key
     * @return summarized representation of all comments
     * @throws de.micromata.jira.rest.core.util.RestException
     */
    public CommentSummaryBean getCommentsByIssue(String issueKey) throws RestException;

    /**
     * Get Attachement as InputStream
     *
     * @param jiraRestClient = = the connected client
     * @param uri            = the uri of the resource
     * @return
     * @throws RestException
     */
    public InputStream getAttachment(JiraRestClient jiraRestClient, URI uri) throws RestException;

    /**
     * Save Attachment to Issue
     */
    public void saveAttachmentToIssue(JiraRestClient jiraRestClient, File file, String issuekey);

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
}
