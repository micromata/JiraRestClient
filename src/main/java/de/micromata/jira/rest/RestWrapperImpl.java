package de.micromata.jira.rest;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.domain.*;
import de.micromata.jira.rest.parser.*;
import org.apache.commons.httpclient.auth.AuthScope;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.client.apache.ApacheHttpClient;
import com.sun.jersey.client.apache.config.ApacheHttpClientConfig;
import com.sun.jersey.client.apache.config.DefaultApacheHttpClientConfig;

import de.micromata.jira.rest.jql.EField;
import de.micromata.jira.rest.jql.EOperator;
import de.micromata.jira.rest.jql.JqlBuilder;
import de.micromata.jira.rest.jql.JqlConstants;
import de.micromata.jira.rest.jql.JqlSearchBean;
import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.JsonConstants;
import de.micromata.jira.rest.util.JsonElementUtil;
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
	public InputStream getAttachment(JiraRestClient jiraRestClient, URI uri) throws RestException {
    	Client client = jiraRestClient.getClient();
    	ClientResponse clientResponse = client.resource(uri).accept(MediaType.APPLICATION_OCTET_STREAM).get(ClientResponse.class);
    	InputStream inputStream = clientResponse.getEntity(InputStream.class);
		return inputStream;
        
	}
	
	@Override
	public boolean transferWorklogInIssue(JiraRestClient jiraRestClient, String issueKey, WorklogBean worklog) throws RestException {
		Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();

        String json = GsonParserUtil.parseWorklogToJson(worklog);
        URI uri = RestURIBuilder.buildIssueWorklogByKeyURI(baseUri, issueKey);
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).entity(json).post(ClientResponse.class);
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_CREATED) {
        	return true;
        }
        else{
            throw new RestException(clientResponse);
        }
	}
	
	@Override
	public boolean updateIssueTransitionByKey(JiraRestClient jiraRestClient, String issueKey, int transitionId) throws RestException {
		Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();

        String json = GsonParserUtil.parseTransitionToJson(transitionId);
        URI uri = RestURIBuilder.buildIssueTransitionsByKeyURI(baseUri, issueKey);
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).entity(json).post(ClientResponse.class);
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_NO_CONTENT) {
        	return true;
        }
        else{
            throw new RestException(clientResponse);
        }
	}

	@Override
	public Map<Integer, TransitionBean> getIssueTransitionsByKey(JiraRestClient jiraRestClient, String issueKey) throws RestException {
		Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildIssueTransitionsByKeyExpandFields(baseUri, issueKey);
        WebResource webResource = client.resource(uri);
        ClientResponse response = webResource.get(ClientResponse.class);
        if(response.getStatus() == HttpURLConnection.HTTP_OK){
        	String entity = response.getEntity(String.class);
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(entity);
            
            JsonElement transitionsElement = jsonObject.get(JsonConstants.PROP_TRANSITIONS);
            if(JsonElementUtil.checkNotNull(transitionsElement)) {
            	JsonArray array = transitionsElement.getAsJsonArray();
            	List<JsonObject> list = GsonParserUtil.parseJsonArray(array);
            	return TransitionParser.parse(list);
            }
            
            return Collections.emptyMap();
        } else {
        	throw new RestException(response);
        }
	}

    @Override
    public UserBean getLoggedInRemoteUser(JiraRestClient jiraRestClient) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildGetUserByUsername(baseUri, jiraRestClient.getUsername());
        WebResource webResource = client.resource(uri);
        ClientResponse response = webResource.get(ClientResponse.class);
        if(response.getStatus() == HttpURLConnection.HTTP_OK){
            String entity = response.getEntity(String.class);
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(entity);
            return UserParser.parse(jsonObject);
        }
        else{
            throw new RestException(response);
        }
    }

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
            List<BasicProjectBean> beans = BasicProjectParser.parseBasicProject(jsonObjects);
            Collections.sort(beans);
            return beans;
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
            List<VersionBean> parse = VersionParser.parse(objects);
            Collections.sort(parse);
            return parse;
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
            List<ComponentBean> parse = ComponentParser.parse(objects);
            Collections.sort(parse);
            return parse;
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
            List<IssueTypeBean> parse = IssueTypeParser.parse(objects);
            Collections.sort(parse);
            return parse;
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
            List<StatusBean> parse = StatusParser.parse(objects);
            Collections.sort(parse);
            return parse;
        }
        else{
            throw new RestException(clientResponse);
        }
    }

    @Override
    public List<PriorityBean> getPriorities(JiraRestClient jiraRestClient) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildStateURI(baseUri);
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.get(ClientResponse.class);
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
            String entity = clientResponse.getEntity(String.class);
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(entity);
            List<PriorityBean> parse = PriorityParser.parse(objects);
            Collections.sort(parse);
            return parse;
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
        String jql = new JqlBuilder().addCondition(EField.PROJECT, EOperator.EQUALS, projectKey).build();
        jsb.setJql(jql);
        jsb.addField(EField.ALL);
        String json = GsonParserUtil.parseObjectToJson(jsb);
        
        URI uri = RestURIBuilder.buildSearchURI(baseUri);
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).entity(json).post(ClientResponse.class);
        
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
      /*      String entity = clientResponse.getEntity(String.class);
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(entity);
            return JqlSearchParser.parse(jsonObject);*/
            InputStream entityInputStream = clientResponse.getEntityInputStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(entityInputStream);
            return JqlSearchParser.parse(jsonObject);
        }
        else{
            throw new RestException(clientResponse);
        }

    }

    @Override
    public JqlSearchResultBean searchIssuesForProject(JiraRestClient jiraRestClient, JqlSearchBean jsb) throws RestException {
    	
    	Client client = jiraRestClient.getClient();
    	URI baseUri = jiraRestClient.getBaseUri();
    	String json = GsonParserUtil.parseObjectToJson(jsb);
    	
    	URI uri = RestURIBuilder.buildSearchURI(baseUri);
    	WebResource webResource = client.resource(uri);
		ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).entity(json).post(ClientResponse.class);

		if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
            String entity = clientResponse.getEntity(String.class);
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(entity);
            JqlSearchResultBean jqlSearchResultBean = JqlSearchParser.parse(jsonObject);
            return jqlSearchResultBean;
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
    public boolean testRestConnection(URI uri, String username, String password) throws RestException {
//    	String authString = username + ":" + password;
//    	String auth = new String(Base64.encode(authString));

    	ApacheHttpClientConfig clientConfig = new DefaultApacheHttpClientConfig();
        clientConfig.getProperties().put(ApacheHttpClientConfig.PROPERTY_HANDLE_COOKIES, Boolean.TRUE);
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        clientConfig.getProperties().put(ApacheHttpClientConfig.PROPERTY_PREEMPTIVE_AUTHENTICATION, Boolean.TRUE);
        clientConfig.getState().setCredentials(AuthScope.ANY_REALM, uri.getHost(), uri.getPort(), username, password);
        ApacheHttpClient client = ApacheHttpClient.create(clientConfig);
        
        URI userUri = UriBuilder.fromUri(uri).path(RestConstants.BASE_REST_PATH).path(USER).build();
        WebResource webResource = client.resource(userUri).queryParam(PARAM_USERNAME, username);
        ClientResponse clientResponse = webResource.
        		//header(RestConstants.AUTHORIZATION, RestConstants.BASIC + auth).
            	type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        
        if(clientResponse.getStatus() == HttpURLConnection.HTTP_OK){
            return true;
        }
        throw new RestException(clientResponse);
    }

}
