package de.micromata.jira.rest;


import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.client.apache.ApacheHttpClient;
import com.sun.jersey.client.apache.config.ApacheHttpClientConfig;
import com.sun.jersey.client.apache.config.DefaultApacheHttpClientConfig;
import com.sun.jersey.core.util.Base64;

import de.micromata.jira.rest.domain.*;
import de.micromata.jira.rest.jql.EField;
import de.micromata.jira.rest.jql.EOperator;
import de.micromata.jira.rest.jql.JqlClause;
import de.micromata.jira.rest.jql.JqlConstants;
import de.micromata.jira.rest.jql.JqlSearchBean;
import de.micromata.jira.rest.parser.*;
import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.RestConstants;
import de.micromata.jira.rest.util.RestException;
import de.micromata.jira.rest.util.RestURIBuilder;

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
        
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildAllProjectURI(baseUri);
        WebResource webResource = client.resource(uri);
        ClientResponse response = webResource.get(ClientResponse.class);
        if(response.getStatus() == HttpURLConnection.HTTP_OK){
            String entity = response.getEntity(String.class);
            List<JsonObject> jsonObjects = GsonParserUtil.parseJsonObjects(entity);
            return BasicProjectParser.parseBasicProject(jsonObjects);
        }
        else{
           throw new RestException(response);
        }
    }

    @Override
    public ProjectBean getProjectByKey(JiraRestClient jiraRestClient, String projectKey) throws RestException {

        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildProjectByKeyURI(baseUri, projectKey);
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.get(ClientResponse.class);
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
    public List<VersionBean> getProjectVersions(JiraRestClient jiraRestClient, String projectKey) throws RestException {
    	
    	Client client = jiraRestClient.getClient();
    	URI baseUri = jiraRestClient.getBaseUri();
    	URI uri = RestURIBuilder.buildProjectVersionsByKeyURI(baseUri, projectKey);
    	WebResource webResource = client.resource(uri);
    	ClientResponse clientResponse = webResource.get(ClientResponse.class);
    	if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
    		String entity = clientResponse.getEntity(String.class);
    		List<JsonObject> objects = GsonParserUtil.parseJsonObjects(entity);
    		return VersionParser.parse(objects);
    	}
    	else{
    		throw new RestException(clientResponse);
    	}
    }
    
    @Override
    public List<ComponentBean> getProjectComponents(JiraRestClient jiraRestClient, String projectKey) throws RestException {
    	
    	Client client = jiraRestClient.getClient();
    	URI baseUri = jiraRestClient.getBaseUri();
    	URI uri = RestURIBuilder.buildProjectComponentsByKeyURI(baseUri, projectKey);
    	WebResource webResource = client.resource(uri);
    	ClientResponse clientResponse = webResource.get(ClientResponse.class);
    	if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
    		String entity = clientResponse.getEntity(String.class);
    		List<JsonObject> objects = GsonParserUtil.parseJsonObjects(entity);
    		return ComponentParser.parse(objects);
    	}
    	else{
    		throw new RestException(clientResponse);
    	}
    }

    @Override
    public List<IssueTypeBean> getIssueTypes(JiraRestClient jiraRestClient) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildIssueTypeURI(baseUri);
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.get(ClientResponse.class);
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
            String entity = clientResponse.getEntity(String.class);
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(entity);
            return IssueTypeParser.parse(objects);
        }
        else{
            throw new RestException(clientResponse);
        }
    }

    @Override
    public List<StatusBean> getStates(JiraRestClient jiraRestClient) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildStateURI(baseUri);
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.get(ClientResponse.class);
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
            String entity = clientResponse.getEntity(String.class);
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(entity);
            return StatusParser.parse(objects);
        }
        else{
            throw new RestException(clientResponse);
        }
    }

    @Override
    public JqlSearchResultBean getIssuesForProject(JiraRestClient jiraRestClient, String projectKey) throws RestException {
        
    	Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        JqlSearchBean jsb = new JqlSearchBean();
        jsb.getClauses().add(new JqlClause(EField.PROJECT, EOperator.EQUALS, projectKey, null));
        jsb.setFieldAll(true);
        
        URI uri = RestURIBuilder.buildSearchURI(baseUri, jsb);
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.get(ClientResponse.class);
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
    public List<IssueBean> searchIssuesForProject(JiraRestClient jiraRestClient, JqlSearchBean jsb) throws RestException {
    	
    	Client client = jiraRestClient.getClient();
    	URI baseUri = jiraRestClient.getBaseUri();
    	URI uri = RestURIBuilder.buildSearchURI(baseUri, jsb);
    	
    	ClientResponse clientResponse = client.resource(uri).get(ClientResponse.class);
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
            String entity = clientResponse.getEntity(String.class);
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(entity);
            JqlSearchResultBean jqlSearchResultBean = JqlSearchParser.parse(jsonObject);
            return jqlSearchResultBean.getIssueBeans();
        }
        else{
            throw new RestException(clientResponse);
        }

    }

    @Override
    public IssueBean getIssueByKey(JiraRestClient jiraRestClient, String issueKey) throws RestException {
    	Client client = jiraRestClient.getClient();
    	URI baseUri = jiraRestClient.getBaseUri();
    	URI uri = RestURIBuilder.buildIssueByKeyURI(baseUri, issueKey);
    	
    	ClientResponse clientResponse = client.resource(uri).get(ClientResponse.class);
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
            String entity = clientResponse.getEntity(String.class);
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(entity);
            return IssueParser.parse(jsonObject);
        }
        else{
            throw new RestException(clientResponse);
        }
    }
    
    @Override
    public CommentSummaryBean getCommentsByIssue(JiraRestClient jiraRestClient, String issueKey) throws RestException {
    	Client client = jiraRestClient.getClient();
    	URI baseUri = jiraRestClient.getBaseUri();
    	URI uri = RestURIBuilder.buildCommentByIssueURI(baseUri, issueKey);
    	
    	ClientResponse clientResponse = client.resource(uri).get(ClientResponse.class);
    	if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
    		String entity = clientResponse.getEntity(String.class);
    		JsonObject jsonObject = GsonParserUtil.parseJsonObject(entity);
    		return CommentSummaryParser.parse(jsonObject);
    	}
    	else{
    		throw new RestException(clientResponse);
    	}
    }

    @Override
    public boolean testRestConnection(URI uri, String username, String password) {
    	String authString = username + ":" + password;
    	String auth = new String(Base64.encode(authString));

    	ApacheHttpClientConfig clientConfig = new DefaultApacheHttpClientConfig();
        clientConfig.getProperties().put(ApacheHttpClientConfig.PROPERTY_HANDLE_COOKIES, Boolean.TRUE);
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        ApacheHttpClient client = ApacheHttpClient.create(clientConfig);
        
        URI userUri = UriBuilder.fromUri(uri).path(RestConstants.BASE_REST_PATH).path(USER).build();
        WebResource webResource = client.resource(userUri).queryParam(PARAM_USERNAME, username);
        ClientResponse clientResponse = webResource.header(RestConstants.AUTHORIZATION, RestConstants.BASIC + auth).
            	type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
            return true;
        }
        return false;
    }


}
