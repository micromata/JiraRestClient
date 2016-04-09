package de.micromata.jira.rest.junit;

import de.micromata.jira.rest.core.domain.UserBean;
import de.micromata.jira.rest.core.domain.permission.MyPermissionsBean;
import de.micromata.jira.rest.core.util.RestException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 09.08.2014
 */
public class TestUserClient extends BaseTest {


    @Test
    public void testGetUserByUsername() throws RestException, IOException, ExecutionException, InterruptedException {
        Future<UserBean> future = jiraRestClient.getUserClient().getUserByUsername(USERNAME_TO_SEARCH);
        final UserBean userBean = future.get();
        Assert.assertNotNull(userBean);
    }

    @Test
    public void testGetLoggedInUser() throws RestException, IOException, ExecutionException, InterruptedException {
        Future<UserBean> future = jiraRestClient.getUserClient().getLoggedInRemoteUser();
        final UserBean userBean = future.get();
        Assert.assertNotNull(userBean);
    }

    @Test
    public void testGetAssignableUserForProject() throws RestException, IOException, ExecutionException, InterruptedException {
        Future<List<UserBean>> future = jiraRestClient.getUserClient().getAssignableUserForProject(PROJECT_TO_SEARCH, null, null);
        final List<UserBean> userBeans = future.get();
        Assert.assertNotNull(userBeans);
        Assert.assertEquals(2, userBeans.size());
    }

    @Test
    public void testGetAssignableUsersForIssue() throws RestException, IOException, ExecutionException, InterruptedException {
        Future<List<UserBean>> future = jiraRestClient.getUserClient().getAssignableUsersForIssue(ISSUEKEY_TO_SEARCH, null, null);
        final List<UserBean> userBeans = future.get();
        Assert.assertNotNull(userBeans);
        Assert.assertEquals(2, userBeans.size());
    }

    @Test
    public void testGetMyPermissions() throws ExecutionException, InterruptedException {
        Future<MyPermissionsBean> future = jiraRestClient.getUserClient().getMyPermissions();
        MyPermissionsBean myPermissionsBean = future.get();
        Assert.assertNotNull(myPermissionsBean);
    }
}
