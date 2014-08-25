package de.micromata.jira.rest.junit;

import de.micromata.jira.rest.core.domain.UserBean;
import de.micromata.jira.rest.core.util.RestException;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 09.08.2014
 */
public class TestUserClient extends BaseTest {


    @Test
    public void testGetUserByUsername() throws RestException, IOException {
        UserBean userBean = jiraRestClient.getUserClient().getUserByUsername(USERNAME_TO_SEARCH);
        Assert.assertNotNull(userBean);
    }

    @Test
    public void testGetLoggedInUser() throws RestException, IOException {
        UserBean loggedInRemoteUser = jiraRestClient.getUserClient().getLoggedInRemoteUser();
        Assert.assertNotNull(loggedInRemoteUser);
    }

    @Test
    public void testGetAssignableUserForProject() throws RestException, IOException {
        List<UserBean> userBeans = jiraRestClient.getUserClient().getAssignableUserForProject(PROJECT_TO_SEARCH, null, null);
        Assert.assertNotNull(userBeans);
        Assert.assertEquals(1, userBeans.size());
    }

    @Test
    public void testGetAssignableUsersForIssue() throws RestException, IOException {
        List<UserBean> userBeans = jiraRestClient.getUserClient().getAssignableUsersForIssue(ISSUEKEY_TO_SEARCH, null, null);
        Assert.assertNotNull(userBeans);
        Assert.assertEquals(1, userBeans.size());
    }
}
