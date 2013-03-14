package de.micromata.jira.rest;



import de.micromata.jira.rest.domain.BasicProjectBean;
import de.micromata.jira.rest.domain.IssueBean;
import de.micromata.jira.rest.domain.JqlSearchResultBean;
import de.micromata.jira.rest.domain.ProjectBean;
import de.micromata.jira.rest.jql.JqlBean;
import de.micromata.jira.rest.util.RestException;

import java.net.URI;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 28.02.13
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
public interface RestWrapper {


    public List<BasicProjectBean> getAllProjects(JiraRestClient jiraRestClient) throws RestException;

    public ProjectBean getProjectByKey(JiraRestClient jiraRestClient, String projectKey) throws RestException;

    public JqlSearchResultBean getIssuesForProject(JiraRestClient jiraRestClient, String projectKey) throws RestException;

    public List<IssueBean> searchIssuesForProject(JiraRestClient jiraRestClient, JqlBean jqlBean) throws RestException;

    public IssueBean getIssueByKey(JiraRestClient jiraRestClient, String issueKey);

    public boolean testRestConnection(URI uri, String username, String password);
}
