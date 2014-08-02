package de.micromata.jira.rest.core;

import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.ProjectClient;
import de.micromata.jira.rest.core.domain.BasicProjectBean;
import de.micromata.jira.rest.core.domain.CommentSummaryBean;
import de.micromata.jira.rest.core.domain.ProjectBean;
import de.micromata.jira.rest.core.domain.VersionBean;
import de.micromata.jira.rest.core.util.RestException;

import java.util.List;

/**
 * Author: Christian
 * Date: 31.07.2014
 */
public class ProjectClientImpl implements ProjectClient{


    private JiraRestClient jiraRestClient = null;

    private ProjectClientImpl() {
    }

    public ProjectClientImpl(JiraRestClient jiraRestClient){
        this.jiraRestClient = jiraRestClient;
    }


    @Override
    public List<BasicProjectBean> getAllProjects() throws RestException {
        return null;
    }

    @Override
    public ProjectBean getProjectByKey(String projectKey) throws RestException {
        return null;
    }

    @Override
    public CommentSummaryBean getCommentsByIssue(String issueKey) throws RestException {
        return null;
    }

    @Override
    public List<VersionBean> getProjectVersions(String projectKey) throws RestException {
        return null;
    }
}
