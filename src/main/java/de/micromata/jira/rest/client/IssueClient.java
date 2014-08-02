package de.micromata.jira.rest.client;

import de.micromata.jira.rest.core.domain.CommentSummaryBean;
import de.micromata.jira.rest.core.domain.IssueBean;
import de.micromata.jira.rest.core.domain.IssueResponse;
import de.micromata.jira.rest.core.util.RestException;

/**
 * The IssueClient provides all Informations for Jira Issues
 */
public interface IssueClient {
    /**
     * Create a new issue
     *
     * @param issue = the issue
     *
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
}
