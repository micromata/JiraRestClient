package de.micromata.jira.rest.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.client.apache.ApacheHttpClient;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.IssueClient;
import de.micromata.jira.rest.core.domain.*;
import de.micromata.jira.rest.core.parser.ErrorParser;
import de.micromata.jira.rest.core.parser.IssueParser;
import de.micromata.jira.rest.core.parser.IssueResponseParser;
import de.micromata.jira.rest.core.parser.TransitionParser;
import de.micromata.jira.rest.core.util.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ws.rs.core.MediaType;
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
public class IssueClientImpl implements IssueClient {

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
        URI uri = RestURIBuilder.buildIssueURI(baseUri);
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
    public CommentSummaryBean getCommentsByIssue(String issueKey) throws RestException {
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
    public void saveAttachmentToIssue(JiraRestClient jiraRestClient, File file, String issuekey) {
        throw new NotImplementedException();

//        ApacheHttpClient client = jiraRestClient.getClient();
//        URI baseUri = jiraRestClient.getBaseUri();
//        URI uri = RestURIBuilder.buildAddAttachmentURI(baseUri, issuekey);
//        WebResource resource = client.resource(uri);
//        resource.getRequestBuilder().header("X-Atlassian-Token", "nocheck");
//        resource.type(MediaType.MULTIPART_FORM_DATA_TYPE);
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

}
