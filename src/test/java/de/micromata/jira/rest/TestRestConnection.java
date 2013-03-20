package de.micromata.jira.rest;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import junit.framework.Assert;

import org.junit.Test;

import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import de.micromata.jira.rest.domain.BasicProjectBean;
import de.micromata.jira.rest.domain.IssueBean;
import de.micromata.jira.rest.domain.JqlSearchResultBean;
import de.micromata.jira.rest.jql.JqlBean;
import de.micromata.jira.rest.jql.JqlConstants;
import de.micromata.jira.rest.parser.BasicProjectParser;
import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.RestConstants;
import de.micromata.jira.rest.util.RestException;
import de.micromata.jira.rest.util.RestURIBuilder;

/**
 * User: Christian
 * Date: 11.03.13
 * Time: 17:17
 */

public class TestRestConnection implements JqlConstants, RestConstants {

	private JiraRestClient jiraRestClient;
	
	public TestRestConnection() {
		String uri = "http://localhost:2990/jira";
        String username = "admin";
        String password = "admin";
        
        jiraRestClient = new JiraRestClient(uri, username, password);
	}
	
    public static void main(String[] args) throws URISyntaxException, RestException {
        TestRestConnection testRestConnection = new TestRestConnection();
        testRestConnection.testRestConnection();
        testRestConnection.testGetProject();
        testRestConnection.testGetIssuesForProject();
        testRestConnection.testSearchIssuesForProject();
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
        List<BasicProjectBean> allProjects = restWrapper.getAllProjects(jiraRestClient);

        System.out.println("testGetProject: " + !allProjects.isEmpty());
    }

    public void testGetIssuesForProject() throws RestException {
        RestWrapper restWrapper = new RestWrapperImpl();
        JqlSearchResultBean resultBean = restWrapper.getIssuesForProject(jiraRestClient, "DEMO");

        System.out.println("testGetIssueForProject: " + !resultBean.getIssueBeans().isEmpty());

    }
    
    public void testSearchIssuesForProject() throws RestException {
    	RestWrapper restWrapper = new RestWrapperImpl();
    	JqlBean jqlBean = new JqlBean();
    	jqlBean.setProjectKey("DEMO");
    	jqlBean.setStatus(STATUS_OPEN);
    	jqlBean.setIssueType(ISSUETYPE_BUG);
    	
    	List<IssueBean> searchIssuesForProject = restWrapper.searchIssuesForProject(jiraRestClient, jqlBean);
    	
    	System.out.println("testSearchIssuesForProject: " + !searchIssuesForProject.isEmpty());
    }
    
//    @Test
    public void testAuthentication() throws RestException, URISyntaxException {
    	
    	String uri = "http://localhost:2990/jira";
        String username = "admin";
        String password = "admin";
        
        JiraRestClient jrc = new JiraRestClient(uri, username, password);
        URI baseUri = jrc.getBaseUri();
        URI userUri = UriBuilder.fromUri(baseUri).path(USER).build();
        Client client = jrc.getClient();
        ClientResponse clientResponse = client.resource(userUri).queryParam(PARAM_USERNAME, username).get(ClientResponse.class);
        
        Assert.assertTrue(clientResponse.getStatus() == HttpURLConnection.HTTP_OK);
        
        URI projectUri = RestURIBuilder.buildAllProjectURI(baseUri);
        clientResponse = client.resource(projectUri).get(ClientResponse.class);
        
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
            String entity = clientResponse.getEntity(String.class);
            List<JsonObject> jsonObjects = GsonParserUtil.parseJsonObjects(entity);
            List<BasicProjectBean> allProjects = BasicProjectParser.parse(jsonObjects);
            Assert.assertTrue(!allProjects.isEmpty());
        }
        
    }

}
