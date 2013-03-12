package de.micromata.jira.rest;

import de.micromata.jira.rest.domain.BasicProjectBean;
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
@Ignore
public class TestRestConnection {


    @Test
    public void testRestConnection() throws URISyntaxException {
        RestWrapper restWrapper = new RestWrapperImpl();
        URI uri = new URI("http://localhost:2990/jira");
        String username = "admin";
        String password = "admin";
        boolean test = restWrapper.testRestConnection(uri, username, password);
        assertEquals(test, true);
    }

    @Test
    public void testGetProject() throws URISyntaxException, RestException {
        RestWrapper restWrapper = new RestWrapperImpl();
        String uri = "http://localhost:2990/jira";
        String username = "admin";
        String password = "admin";
        JiraRestClient jiraRestClient = new JiraRestClient(uri, username, password);
        List<BasicProjectBean> allProjects = restWrapper.getAllProjects(jiraRestClient);
        assertFalse(allProjects.isEmpty());


    }

}
