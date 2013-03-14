package de.micromata.jira.rest;


import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.Base64;
import de.micromata.jira.rest.domain.BasicProjectBean;
import de.micromata.jira.rest.domain.IssueBean;
import de.micromata.jira.rest.domain.JqlSearchResultBean;
import de.micromata.jira.rest.domain.ProjectBean;
import de.micromata.jira.rest.jql.JqlBean;
import de.micromata.jira.rest.jql.JqlConstants;
import de.micromata.jira.rest.parser.BasicProjectParser;
import de.micromata.jira.rest.parser.JqlSearchParser;
import de.micromata.jira.rest.parser.ProjectParser;
import de.micromata.jira.rest.util.RestConstants;
import de.micromata.jira.rest.util.RestException;
import de.micromata.jira.rest.util.RestURIBuilder;
import de.micromata.jira.rest.util.GsonParserUtil;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 28.02.13
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
public class RestWrapperImpl implements RestWrapper, RestConstants, JqlConstants {


    @Override
    public List<BasicProjectBean> getAllProjects(JiraRestClient jiraRestClient) throws RestException {
        String auth = jiraRestClient.getAuth();
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildAllProjectURI(baseUri);
        WebResource webResource = client.resource(uri);
        ClientResponse response = webResource.header(AUTHORIZATION, BASIC + auth).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if(response.getStatus() == HttpURLConnection.HTTP_OK){
            String entity = response.getEntity(String.class);
            List<JsonObject> jsonObjects = GsonParserUtil.parseJsonObjects(entity);
            return BasicProjectParser.parse(jsonObjects);
        }
        else{
           throw new RestException(response);
        }
    }

    @Override
    public ProjectBean getProjectByKey(JiraRestClient jiraRestClient, String projectKey) throws RestException {

        String auth = jiraRestClient.getAuth();
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildProjectByKeyURI(baseUri, projectKey);
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.header(AUTHORIZATION, BASIC + auth).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
            String entity = clientResponse.getEntity(String.class);
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(entity);
            return ProjectParser.parse(jsonObject);
        }
        else{
            throw new RestException(clientResponse);
        }
    }

    @Override
    public JqlSearchResultBean getIssuesForProject(JiraRestClient jiraRestClient, String projectKey) throws RestException {
        String auth = jiraRestClient.getAuth();
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        JqlBean jqlBean = new JqlBean();
        jqlBean.setProjectKey(projectKey);
        jqlBean.addField( FIELD_SUMMARY ,FIELD_SUMMARY, FIELD_STATUS, FIELD_DUEDATE, FIELD_PRIORITY);
        URI uri = RestURIBuilder.buildSearchURI(baseUri, jqlBean);
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.header(AUTHORIZATION, BASIC + auth).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
            String entity = clientResponse.getEntity(String.class);
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(entity);
            return JqlSearchParser.parse(jsonObject);
        }
        else{
            throw new RestException(clientResponse);
        }

    }

    @Override
    public List<IssueBean> searchIssuesForProject(JiraRestClient jiraRestClient, JqlBean jqlBean) throws RestException {
        return null;
    }

    @Override
    public IssueBean getIssueByKey(JiraRestClient jiraRestClient, String issueKey) {
        return null;
    }

    @Override
    public boolean testRestConnection(URI uri, String username, String password) {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
                Boolean.TRUE);
        Client client = Client.create(clientConfig);
        String authString = username + ":" + password;
        String auth = new String(Base64.encode(authString));
        URI userUri = UriBuilder.fromUri(uri).path(RestConstants.BASE_REST_PATH).path(USER).build();
        WebResource webResource = client.resource(userUri).queryParam(PARAM_USERNAME, username);
        ClientResponse clientResponse = webResource.header("Authorization", "Basic " + auth).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
            return true;
        }
        return false;
    }


}
