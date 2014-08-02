package de.micromata.jira.rest.core;

import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.SystemClient;
import de.micromata.jira.rest.core.domain.IssueTypeBean;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.StatusBean;
import de.micromata.jira.rest.core.util.RestException;

import java.util.List;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 31.07.2014
 */
public class SystemClientImpl implements SystemClient {


    private JiraRestClient jiraRestClient = null;

    private SystemClientImpl() {
    }

    public SystemClientImpl(JiraRestClient jiraRestClient){
        this.jiraRestClient = jiraRestClient;
    }


    @Override
    public List<IssueTypeBean> getIssueTypes(JiraRestClient jiraRestClient) throws RestException {
        return null;
    }

    @Override
    public List<StatusBean> getStates(JiraRestClient jiraRestClient) throws RestException {
        return null;
    }

    @Override
    public List<PriorityBean> getPriorities(JiraRestClient jiraRestClient) throws RestException {
        return null;
    }
}
