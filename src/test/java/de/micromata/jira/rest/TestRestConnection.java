package de.micromata.jira.rest;

import de.micromata.jira.rest.domain.BasicProjectBean;
import de.micromata.jira.rest.domain.IssueBean;
import de.micromata.jira.rest.domain.JqlSearchResultBean;
import de.micromata.jira.rest.util.RestException;
import org.junit.Ignore;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * User: Christian
 * Date: 11.03.13
 * Time: 17:17
 */

public class TestRestConnection {

    public static void main(String[] args) throws URISyntaxException, RestException {
        TestRestConnection testRestConnection = new TestRestConnection();
        testRestConnection.testRestConnection();
        testRestConnection.testGetProject();
        testRestConnection.testGetIssuesForProject();
    }

    public void testRestConnection() throws URISyntaxException {
        RestWrapper restWrapper = new RestWrapperImpl();
        URI uri = new URI("http://localhost:2990/jira");
        String username = "admin";
        String password = "admin";
        boolean test = restWrapper.testRestConnection(uri, username, password);

        System.out.println("testRestConnection: " + test);
    }


    public void testGetProject() throws URISyntaxException, RestException {
        RestWrapper restWrapper = new RestWrapperImpl();
        String uri = "http://localhost:2990/jira";
        String username = "admin";
        String password = "admin";
        JiraRestClient jiraRestClient = new JiraRestClient(uri, username, password);
        List<BasicProjectBean> allProjects = restWrapper.getAllProjects(jiraRestClient);
        System.out.println("testGetProject: " + !allProjects.isEmpty());
    }


    public void testGetIssuesForProject() throws RestException {
        RestWrapper restWrapper = new RestWrapperImpl();
        String uri = "http://localhost:2990/jira";
        String username = "admin";
        String password = "admin";
        JiraRestClient jiraRestClient = new JiraRestClient(uri, username, password);
        JqlSearchResultBean resultBean = restWrapper.getIssuesForProject(jiraRestClient, "DEMO");

        System.out.println("testGetIssueForProject: " + !resultBean.getIssueBeans().isEmpty());

    }

}
