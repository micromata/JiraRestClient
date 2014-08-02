package de.micromata.jira.rest.core;

import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.UserClient;
import de.micromata.jira.rest.core.domain.UserBean;

import java.util.List;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 02.08.2014
 */
public class UserClientImpl implements UserClient {

    private JiraRestClient jiraRestClient;

    private UserClientImpl() {
    }

    public UserClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
    }

    @Override
    public List<UserBean> getUsersForProject(String projectKey) {
        return null;
    }

    @Override
    public UserBean getUserByUsername(String username) {
        return null;
    }
}
