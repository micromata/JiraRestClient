package de.micromata.jira.rest.junit;

import de.micromata.jira.rest.core.domain.UserBean;
import de.micromata.jira.rest.core.util.RestException;
import junit.framework.Assert;
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
        while (future.isDone() == false) ;
        final UserBean userBean = future.get();
        Assert.assertNotNull(userBean);
    }

    @Test
    public void testGetLoggedInUser() throws RestException, IOException, ExecutionException, InterruptedException {
        Future<UserBean> future = jiraRestClient.getUserClient().getLoggedInRemoteUser();
        while (future.isDone() == false) ;
        final UserBean userBean = future.get();
        Assert.assertNotNull(userBean);
    }

    @Test
    public void testGetAssignableUserForProject() throws RestException, IOException, ExecutionException, InterruptedException {
        Future<List<UserBean>> future = jiraRestClient.getUserClient().getAssignableUserForProject(PROJECT_TO_SEARCH, null, null);
        while (future.isDone() == false) ;
        final List<UserBean> userBeans = future.get();
        Assert.assertNotNull(userBeans);
        Assert.assertEquals(1, userBeans.size());
    }

    @Test
    public void testGetAssignableUsersForIssue() throws RestException, IOException, ExecutionException, InterruptedException {
        Future<List<UserBean>> future = jiraRestClient.getUserClient().getAssignableUsersForIssue(ISSUEKEY_TO_SEARCH, null, null);
        while (future.isDone() == false) ;
        final List<UserBean> userBeans = future.get();
        Assert.assertNotNull(userBeans);
        Assert.assertEquals(1, userBeans.size());
    }
}
