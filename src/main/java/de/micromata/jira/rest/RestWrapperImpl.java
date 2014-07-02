/*
 * Copyright 2013 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.micromata.jira.rest;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import de.micromata.jira.rest.domain.*;
import de.micromata.jira.rest.parser.*;
import org.apache.commons.httpclient.auth.AuthScope;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
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
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class RestWrapperImpl implements RestWrapper, RestConstants, JqlConstants {

	@Override
	public IssueResponse createIssue(IssueBean issue, JiraRestClient jiraRestClient)
			throws RestException {
		Client client = jiraRestClient.getClient();
		URI baseUri = jiraRestClient.getBaseUri();
		String json = GsonParserUtil.parseIssueToJson(issue);
		URI uri = RestURIBuilder.buildIssueURI(baseUri);
		WebResource webResource = client.resource(uri);
        ClientResponse response = webResource.entity(json)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.post(ClientResponse.class);
        int status = response.getStatus();
        if(status == HttpURLConnection.HTTP_OK){
            InputStream inputStream = response.getEntityInputStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            return IssueResponseParser.parse(jsonObject);
        }
        if(status == HttpURLConnection.HTTP_BAD_REQUEST){
            InputStream entityInputStream = response.getEntityInputStream();
            ErrorBean parse = ErrorParser.parse(entityInputStream);
            System.out.println(parse);
        }

        return null;
	}
	
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
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_CREATED) {
            clientResponse.close();
            return true;
        } else {
            clientResponse.close();
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
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_NO_CONTENT) {
            clientResponse.close();
            return true;
        } else {
            clientResponse.close();
            throw new RestException(clientResponse);
        }
    }

    @Override
    public List<TransitionBean> getIssueTransitionsByKey(JiraRestClient jiraRestClient, String issueKey) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildIssueTransitionsByKeyExpandFields(baseUri, issueKey);
        WebResource webResource = client.resource(uri);
        ClientResponse response = webResource.get(ClientResponse.class);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = response.getEntityInputStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            JsonElement transitionsElement = jsonObject.get(JsonConstants.PROP_TRANSITIONS);
            if (JsonElementUtil.checkNotNull(transitionsElement)) {
                JsonArray array = transitionsElement.getAsJsonArray();
                List<JsonObject> list = GsonParserUtil.parseJsonArray(array);
                response.close();
                return TransitionParser.parse(list);
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.close();
            return Collections.emptyList();
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
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = response.getEntityInputStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.close();
            return UserParser.parse(jsonObject);
        } else {
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
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = response.getEntityInputStream();
            List<JsonObject> jsonObjects = GsonParserUtil.parseJsonObjects(inputStream);
            List<BasicProjectBean> beans = BasicProjectParser.parseBasicProject(jsonObjects);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.close();
            Collections.sort(beans);
            return beans;
        } else {
            throw new RestException(response);
        }
    }

    @Override
    public ProjectBean getProjectByKey(JiraRestClient jiraRestClient, String projectKey) throws RestException {

        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildProjectByKeyURI(baseUri, projectKey);
        WebResource webResource = client.resource(uri);
        ClientResponse response = webResource.get(ClientResponse.class);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = response.getEntityInputStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.close();
            return ProjectParser.parse(jsonObject);
        } else {
            throw new RestException(response);
        }
    }

    @Override
    public List<VersionBean> getProjectVersions(JiraRestClient jiraRestClient, String projectKey) throws RestException {

        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildProjectVersionsByKeyURI(baseUri, projectKey);
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.get(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<VersionBean> parse = VersionParser.parse(objects);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientResponse.close();
            Collections.sort(parse);
            return parse;
        } else {
            clientResponse.close();
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
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<ComponentBean> parse = ComponentParser.parse(objects);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientResponse.close();
            Collections.sort(parse);
            return parse;
        } else {
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
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<IssueTypeBean> parse = IssueTypeParser.parse(objects);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientResponse.close();
            Collections.sort(parse);
            return parse;
        } else {
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
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<StatusBean> parse = StatusParser.parse(objects);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientResponse.close();
            Collections.sort(parse);
            return parse;
        } else {
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
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<PriorityBean> parse = PriorityParser.parse(objects);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientResponse.close();
            Collections.sort(parse);
            return parse;
        } else {
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

        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream entityInputStream = clientResponse.getEntityInputStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(entityInputStream);
            try {
                entityInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientResponse.close();
            return JqlSearchParser.parse(jsonObject);
        } else {
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

        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            JqlSearchResultBean jqlSearchResultBean = JqlSearchParser.parse(jsonObject);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientResponse.close();
            return jqlSearchResultBean;
        } else {
            throw new RestException(clientResponse);
        }

    }

    @Override
    public IssueBean getIssueByKey(JiraRestClient jiraRestClient, String issueKey) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildIssueByKeyURI(baseUri, issueKey);

        ClientResponse clientResponse = client.resource(uri).get(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientResponse.close();
            return IssueParser.parse(jsonObject);
        } else {
            throw new RestException(clientResponse);
        }
    }

    @Override
    public CommentSummaryBean getCommentsByIssue(JiraRestClient jiraRestClient, String issueKey) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = RestURIBuilder.buildCommentByIssueURI(baseUri, issueKey);

        ClientResponse clientResponse = client.resource(uri).get(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientResponse.close();
            return CommentSummaryParser.parse(jsonObject);
        } else {
            throw new RestException(clientResponse);
        }
    }

    @Override
    public boolean testRestConnection(URI uri, String username, String password) throws RestException, ClientHandlerException {

        ApacheHttpClientConfig clientConfig = new DefaultApacheHttpClientConfig();
        clientConfig.getProperties().put(ApacheHttpClientConfig.PROPERTY_HANDLE_COOKIES, Boolean.TRUE);
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        clientConfig.getProperties().put(ApacheHttpClientConfig.PROPERTY_PREEMPTIVE_AUTHENTICATION, Boolean.TRUE);
        clientConfig.getState().setCredentials(AuthScope.ANY_REALM, uri.getHost(), uri.getPort(), username, password);
        ApacheHttpClient client = ApacheHttpClient.create(clientConfig);

        URI userUri = UriBuilder.fromUri(uri).path(RestConstants.BASE_REST_PATH).path(USER).build();
        WebResource webResource = client.resource(userUri).queryParam(PARAM_USERNAME, username);

        ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            return true;
        }
        try {
            throw new RestException(clientResponse.getStatus(), null, null);
        } finally {
            clientResponse.close();
        }
    }
}
