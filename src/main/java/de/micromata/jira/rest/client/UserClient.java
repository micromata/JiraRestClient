package de.micromata.jira.rest.client;

import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.core.domain.UserBean;
import de.micromata.jira.rest.core.util.RestException;

import java.util.List;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 02.08.2014
 */
public interface UserClient {


    /**
     * Returns a List of UserBean which are assignable to Issue in a Project
     *
     * @param projectKey the projectkey
     * @param startAt start at position (0-based) can be null the default (0)
     * @param maxResults Number of Results (default 50) can be null then default (50)
     * @return
     */
    public List<UserBean> getAssignableUserForProject(String projectKey, Integer startAt, Integer maxResults) throws RestException;


    /**
     * Returns a List of UserBean which are assignable to an Issue
     *
     * @param issueKey The Issuekey
     * @param startAt start at position (0-based) can be null the default (0)
     * @param maxResults Number of Results (default 50) can be null then default (50)
     * @return
     */
    public List<UserBean> getAssignableUsersForIssue(String issueKey, Integer startAt, Integer maxResults) throws RestException;

    /**
     * Returns a User by his username
     *
     * @param username The username of the User
     * @return UserBean
     */
    public UserBean getUserByUsername(String username) throws RestException;

    /**
     * Returns the logged in remote user.
     *
     * @return logged in user
     * @throws RestException
     */
    public UserBean getLoggedInRemoteUser() throws RestException;
}
