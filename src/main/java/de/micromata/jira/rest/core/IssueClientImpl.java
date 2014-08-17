package de.micromata.jira.rest.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.IssueClient;
import de.micromata.jira.rest.core.domain.*;
import de.micromata.jira.rest.core.parser.*;
import de.micromata.jira.rest.core.util.*;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/**
 * Author: Christian
 * Date: ${Date}
 */
public class IssueClientImpl implements IssueClient, RestParamConstants, RestPathConstants {

    private static final String SEPARATOR = ",";
    private JiraRestClient jiraRestClient = null;

    private IssueClientImpl() {
    }

    public IssueClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
    }


    @Override
    public IssueResponse createIssue(IssueBean issue)
            throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        String json = IssueParser.parseIssueToJson(issue);
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).build();
        WebResource webResource = client.resource(uri);
        ClientResponse response = webResource.entity(json)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class);
        int status = response.getStatus();
        if (status == HttpURLConnection.HTTP_OK || status == HttpURLConnection.HTTP_CREATED) {
            InputStream inputStream = response.getEntityInputStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            return IssueResponseParser.parse(jsonObject);
        }
        if (status == HttpURLConnection.HTTP_BAD_REQUEST) {
            InputStream entityInputStream = response.getEntityInputStream();
            ErrorBean parse = ErrorParser.parse(entityInputStream);
            return new IssueResponse(parse);
        }
        return null;
    }

    @Override
    public IssueBean getIssueByKey(String issueKey) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).build();
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
    public IssueBean getIssueByKey(String issueKey, List<String> fields, List<String> expand) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        UriBuilder path = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey);
        String fieldsParam = StringUtils.join(fields, SEPARATOR);
        path.queryParam(FIELDS, fieldsParam);
        String expandParam = StringUtils.join(expand, SEPARATOR);
        path.queryParam(EXPAND, expandParam);
        URI uri = path.build();
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
    public CommentSummaryBean getCommentsByIssue(String issueKey) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(COMMENT).build();
        ClientResponse clientResponse = client.resource(uri).get(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return CommentSummaryParser.parse(jsonObject);
        } else {
            throw new RestException(clientResponse);
        }
    }

    @Override
    public InputStream getAttachment(URI uri) throws RestException {
        Client client = jiraRestClient.getClient();
        ClientResponse clientResponse = client.resource(uri).accept(MediaType.APPLICATION_OCTET_STREAM).get(ClientResponse.class);
        InputStream inputStream = clientResponse.getEntity(InputStream.class);
        return inputStream;
    }


    @Override
    public void saveAttachmentToIssue(File file, String issuekey) {

//        ApacheHttpClient client = jiraRestClient.getClient();
//        URI baseUri = jiraRestClient.getBaseUri();
//        URI uri = RestURIBuilder.buildAddAttachmentURI(baseUri, issuekey);
//        WebResource resource = client.resource(uri);
//        resource.getRequestBuilder().header("X-Atlassian-Token", "nocheck");
//        resource.type(MediaType.MULTIPART_FORM_DATA_TYPE);
    }

    @Override
    public boolean transferWorklogInIssue(String issueKey, WorklogBean worklog) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        String json = GsonParserUtil.parseWorklogToJson(worklog);
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(WORKLOG).build();
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).entity(json).post(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_CREATED) {
            clientResponse.close();
            return true;
        } else {
            throw new RestException(clientResponse);
        }
    }

    @Override
    public boolean updateIssueTransitionByKey(String issueKey, int transitionId) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();

        String json = GsonParserUtil.parseTransitionToJson(transitionId);
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(TRANSITIONS).build();
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).entity(json).post(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_NO_CONTENT) {
            clientResponse.close();
            return true;
        } else {
            throw new RestException(clientResponse);
        }
    }

    @Override
    public List<TransitionBean> getIssueTransitionsByKey(String issueKey) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        UriBuilder path = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(TRANSITIONS);
        path.queryParam(EXPAND, TRANSITIONS_FIELDS);
        URI uri = path.build();
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

}
