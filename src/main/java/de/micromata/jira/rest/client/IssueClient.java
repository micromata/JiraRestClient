package de.micromata.jira.rest.client;

import de.micromata.jira.rest.core.domain.*;
import de.micromata.jira.rest.core.domain.update.IssueUpdate;
import de.micromata.jira.rest.core.util.RestException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.Future;

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
    Future<IssueResponse> createIssue(IssueBean issue) throws RestException, IOException;


    /**
     * Returns a full representation of the issue for the given issue key.
     *
     * @param issueKey = issue key
     * @return all informations for the issue or null if the issue did not exist
     * @throws RestException
     */
    Future<IssueBean> getIssueByKey(String issueKey) throws RestException, IOException;

    /**
     * update Field of an Issue
     *
     *
     */
    Future<IssueBean> updateIssue(String issueKey, IssueUpdate issueUpdate) throws IOException, RestException;

    /**
     * Return a Issue with the given Field and Expand Fields.
     *
     * @param issueKey The IssueKey
     * @param fields The field you want to return.
     * @param expand The Field which must expand.
     * @return IssueBean or null if the issue did not exist
     */
    Future<IssueBean> getIssueByKey(String issueKey, List<String> fields, List<String> expand) throws RestException, IOException;

    /**
     * Get Attachement as byte Array, or null
     *
     * @param uri = the uri of the resource
     * @return byte[] or null
     * @throws RestException
     */
    Future<Byte[]> getAttachment(URI uri) throws RestException, IOException;


    /**
     * Get Attachment as InputStream
     *
     * @param id the Id of the Attachment
     * @return
     */
    InputStream getAttachmentAsStream(long id);


    /**
     * Get Attachment Information for an attachment by id
     *
     * @param id the id of the attachment
     * @return
     */
    Future<AttachmentBean> getAttachment(long id) throws IOException, RestException;

    /**
     * Save Attachment to Issue
     */
    void saveAttachmentToIssue(File file, String issuekey) throws IOException, RestException;

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
    boolean transferWorklogInIssue(String issueKey,
                                          WorklogBean worklog) throws RestException, IOException, URISyntaxException;

    /**
     * Returns true if the transition update on an Issue success.
     *
     * @param issueKey     = the issue key
     * @param transitionId = the transition id
     * @return success state
     * @throws RestException
     */
    boolean updateIssueTransitionByKey(String issueKey, int transitionId) throws RestException, IOException, URISyntaxException;

    /**
     * Returns available transitions for an Issue in a map with transition id and properties.
     *
     * @param issueKey = the issue key
     * @return List of TransitionBean
     * @throws RestException
     */
    Future<List<TransitionBean>> getIssueTransitionsByKey(String issueKey) throws RestException, IOException;

    /**
     * Returns a summarized representation of all comments for the given issue.
     *
     * @param issueKey = issue key
     * @return summarized representation of all comments
     * @throws de.micromata.jira.rest.core.util.RestException
     */
    Future<CommentsBean> getCommentsByIssue(String issueKey) throws RestException, IOException;

}
