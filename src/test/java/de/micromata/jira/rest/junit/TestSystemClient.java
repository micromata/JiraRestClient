package de.micromata.jira.rest.junit;


import de.micromata.jira.rest.core.domain.IssuetypeBean;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.StatusBean;
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
public class TestSystemClient extends BaseTest {

    private static final int STANDARD_NUMBER_OF_ISSUETYPES = 5;
    private static final int STANDARD_NUMBER_OF_STATES = 5;
    private static final int STANDARD_NUMBER_OF_PRIORITIES = 5;

    @Test
    public void testGetIssueType() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<List<IssuetypeBean>> future = jiraRestClient.getSystemClient().getIssueTypes();
        while (future.isDone() == false) ;
        final List<IssuetypeBean> issuetypeBeans = future.get();
        Assert.assertNotNull(issuetypeBeans);
        Assert.assertFalse(issuetypeBeans.isEmpty());
        Assert.assertEquals(STANDARD_NUMBER_OF_ISSUETYPES, issuetypeBeans.size());
    }

    @Test
    public void testGetPriorities() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<List<PriorityBean>> future = jiraRestClient.getSystemClient().getPriorities();
        while (future.isDone() == false) ;
        final List<PriorityBean> priorities = future.get();
        Assert.assertNotNull(priorities);
        Assert.assertFalse(priorities.isEmpty());
        Assert.assertEquals(STANDARD_NUMBER_OF_PRIORITIES, priorities.size());
    }

    @Test
    public void testGetStates() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<List<StatusBean>> future = jiraRestClient.getSystemClient().getStates();
        while (future.isDone() == false) ;
        final List<StatusBean> statusBeans = future.get();
        Assert.assertNotNull(statusBeans);
        Assert.assertFalse(statusBeans.isEmpty());
        Assert.assertEquals(STANDARD_NUMBER_OF_STATES, statusBeans.size());
    }
}
