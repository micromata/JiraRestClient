package de.micromata.jira.rest.junit;

import de.micromata.jira.rest.core.domain.UserBean;
import de.micromata.jira.rest.core.util.RestException;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 09.08.2014
 */
public class TestUserClient extends BaseTest {


    static final String USERNAME_TO_SEARCH = "admin";

    static final String ISSUEKEY_TO_SEARCH = "DEMO-1";

    static final String PROJECT_TO_SEARCH = "DEMO";

    @Test
    public void testGetUserByUsername() throws RestException {
        UserBean userBean = jiraRestClient.getUserClient().getUserByUsername(USERNAME_TO_SEARCH);
        Assert.assertNotNull(userBean);
    }

    @Test
    public void testGetLoggedInUser() throws RestException {
        UserBean loggedInRemoteUser = jiraRestClient.getUserClient().getLoggedInRemoteUser();
        Assert.assertNotNull(loggedInRemoteUser);
    }

    @Test
    public void testGetAssignableUserForProject() throws RestException {
        List<UserBean> userBeans = jiraRestClient.getUserClient().getAssignableUserForProject(PROJECT_TO_SEARCH, null, null);
        Assert.assertNotNull(userBeans);
        Assert.assertEquals(1, userBeans.size());
    }

    @Test
    public void testGetAssignableUsersForIssue() throws RestException {
        List<UserBean> userBeans = jiraRestClient.getUserClient().getAssignableUsersForIssue(ISSUEKEY_TO_SEARCH, null, null);
        Assert.assertNotNull(userBeans);
        Assert.assertEquals(1, userBeans.size());
    }
}
