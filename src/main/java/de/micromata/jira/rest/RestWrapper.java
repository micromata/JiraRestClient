package de.micromata.jira.rest;



import java.net.URI;
import java.util.List;

import de.micromata.jira.rest.domain.*;
import de.micromata.jira.rest.jql.JqlBean;
import de.micromata.jira.rest.jql.JqlBean2;
import de.micromata.jira.rest.util.RestException;

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

    public IssueBean getIssueByKey(JiraRestClient jiraRestClient, String issueKey) throws RestException;

    public boolean testRestConnection(URI uri, String username, String password);

	public CommentSummaryBean getCommentsByIssue(JiraRestClient jiraRestClient,
			String issueKey) throws RestException;

	public List<VersionBean> getProjectVersions(JiraRestClient jiraRestClient,
			String projectKey) throws RestException;

	public List<ComponentBean> getProjectComponents(JiraRestClient jiraRestClient,
			String projectKey) throws RestException;

    public List<IssueTypeBean> getIssueTypes(JiraRestClient jiraRestClient) throws RestException;

	List<IssueBean> searchIssuesForProject2(JiraRestClient jiraRestClient,
			JqlBean2 jqlBean) throws RestException;
}
