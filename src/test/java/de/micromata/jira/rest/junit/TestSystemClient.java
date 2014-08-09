package de.micromata.jira.rest.junit;


import de.micromata.jira.rest.core.domain.IssueTypeBean;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.StatusBean;
import de.micromata.jira.rest.core.util.RestException;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 09.08.2014
 */
public class TestSystemClient extends BaseTest {

    private static final int STANDARD_NUMBER_OF_ISSUETYPES = 5;
    private static final int STANDARD_NUMBER_OF_STATES = 5;
    private static final int STANDARD_NUMBER_OF_PRIORITIES = 5;

    @Test
    public void testGetIssueType() throws RestException {
        List<IssueTypeBean> issueTypes = jiraRestClient.getSystemClient().getIssueTypes();
        Assert.assertNotNull(issueTypes);
        Assert.assertFalse(issueTypes.isEmpty());
        Assert.assertEquals(STANDARD_NUMBER_OF_ISSUETYPES, issueTypes.size());
    }

    @Test
    public void testGetPriorities() throws RestException {
        List<PriorityBean> priorities = jiraRestClient.getSystemClient().getPriorities();
        Assert.assertNotNull(priorities);
        Assert.assertFalse(priorities.isEmpty());
        Assert.assertEquals(STANDARD_NUMBER_OF_PRIORITIES, priorities.size());
    }

    @Test
    public void testGetStates() throws RestException {
        List<StatusBean> states = jiraRestClient.getSystemClient().getStates();
        Assert.assertNotNull(states);
        Assert.assertFalse(states.isEmpty());
        Assert.assertEquals(STANDARD_NUMBER_OF_STATES, states.size());
    }
}
