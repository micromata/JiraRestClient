package de.micromata.jira.rest.core;

import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.IssueClient;

/**
 * Author: Christian
 * Date: ${Date}
 */
public class IssueClientImpl implements IssueClient {

    private JiraRestClient jiraRestClient = null;

    private IssueClientImpl() {
    }

    public IssueClientImpl(JiraRestClient jiraRestClient){
        this.jiraRestClient = jiraRestClient;
    }


}
