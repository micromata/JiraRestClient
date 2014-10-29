package de.micromata.jira.rest.client;

import de.micromata.jira.rest.core.domain.*;
import de.micromata.jira.rest.core.domain.update.IssueUpdateBean;
import de.micromata.jira.rest.core.util.RestException;

import java.io.File;
import java.io.IOException;
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
    public IssueResponse createIssue(IssueBean issue) throws RestException, IOException;


    /**
     * Returns a full representation of the issue for the given issue key.
     *
     * @param issueKey = issue key
     * @return all informations for the issue
     * @throws RestException
     */
    public IssueBean getIssueByKey(String issueKey) throws RestException, IOException;

    /**
     * update Field of an Issue
     *
     *
     */
    public IssueBean updateIssue(String issueKey, IssueUpdateBean issueUpdateBean) throws IOException, RestException;

    /**
     * Return a Issue with the given Field and Expand Fields.
     *
     * @param issueKey The IssueKey
     * @param fields The field you want to return.
     * @param expand The Field which must expand.
     * @return IssueBean
     */
    public IssueBean getIssueByKey(String issueKey, List<String> fields, List<String> expand) throws RestException, IOException;

    /**
     * Get Attachement as byte Array, or null
     *
     * @param uri = the uri of the resource
     * @return byte[] or null
     * @throws RestException
     */
    public byte[] getAttachment(URI uri) throws RestException, IOException;

    /**
     * Save Attachment to Issue
     */
    public void saveAttachmentToIssue(File file, String issuekey);

    /**
     * Returns true if the worklog is successfully transfered to the Issue.
     * <p/>
     * <p>This method is for merging log time for an Issue.
     *
     * @param issueKey = the issue key
     * @param worklog  = the one which would be transfered
     * @return created state
     * @throws RestException
     */
    public boolean transferWorklogInIssue(String issueKey,
                                          WorklogBean worklog) throws RestException, IOException;

    /**
     * Returns true if the transition update on an Issue success.
     *
     * @param issueKey     = the issue key
     * @param transitionId = the transition id
     * @return success state
     * @throws RestException
     */
    public boolean updateIssueTransitionByKey(String issueKey, int transitionId) throws RestException, IOException;

    /**
     * Returns available transitions for an Issue in a map with transition id and properties.
     *
     * @param issueKey = the issue key
     * @return List of TransitionBean
     * @throws RestException
     */
    public List<TransitionBean> getIssueTransitionsByKey(String issueKey) throws RestException, IOException;

    /**
     * Returns a summarized representation of all comments for the given issue.
     *
     * @param issueKey = issue key
     * @return summarized representation of all comments
     * @throws de.micromata.jira.rest.core.util.RestException
     */
    public CommentSummaryBean getCommentsByIssue(String issueKey) throws RestException, IOException;

}
