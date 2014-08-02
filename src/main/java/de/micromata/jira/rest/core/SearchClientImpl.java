package de.micromata.jira.rest.core;

import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.SearchClient;
import de.micromata.jira.rest.core.domain.JqlSearchResultBean;
import de.micromata.jira.rest.core.jql.JqlSearchBean;
import de.micromata.jira.rest.core.util.RestException;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 01.08.2014
 */
public class SearchClientImpl implements SearchClient {


    private JiraRestClient jiraRestClient = null;

    private SearchClientImpl() {
    }

    public SearchClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
    }

    @Override
    public JqlSearchResultBean searchIssuesForProject(JiraRestClient jiraRestClient, JqlSearchBean jsb) throws RestException {
        return null;
    }
}
