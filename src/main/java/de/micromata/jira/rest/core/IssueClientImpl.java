package de.micromata.jira.rest.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.IssueClient;
import de.micromata.jira.rest.core.domain.*;
import de.micromata.jira.rest.core.domain.update.IssueUpdate;
import de.micromata.jira.rest.core.util.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: Christian
 * Date: ${Date}
 */
public class IssueClientImpl extends BaseClient implements IssueClient, RestParamConstants, RestPathConstants {

    private static final String SEPARATOR = ",";
    private JiraRestClient jiraRestClient = null;

    private IssueClientImpl() {
    }

    public IssueClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
    }


    @Override
    public IssueResponse createIssue(Issue issue)
            throws RestException, IOException {
//        HttpClient client = jiraRestClient.getClient();
//        URI baseUri = jiraRestClient.getBaseUri();
//        String json = IssueParser.parseIssueToJson(issue);
//        URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).build();
//        PostMethod method = HttpMethodFactory.createPostMethod(uri, json);
//        int status = client.executeMethod(method);
//        if (status == HttpURLConnection.HTTP_OK || status == HttpURLConnection.HTTP_CREATED) {
//            InputStream inputStream = method.getResponseBodyAsStream();
//            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
//            method.releaseConnection();
//            return IssueResponseParser.parse(jsonObject);
//        } else if (status == HttpURLConnection.HTTP_BAD_REQUEST) {
//            InputStream entityInputStream = method.getResponseBodyAsStream();
//            ErrorBean parse = ErrorParser.parse(entityInputStream);
//            method.releaseConnection();
//            return new IssueResponse(parse);
//        } else {
//            method.releaseConnection();
//            throw new RestException(method);
//        }
        return null;
    }

    @Override
    public Issue getIssueByKey(String issueKey) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonReader jsonReader = toJsonReader(inputStream);
            return (Issue) gson.fromJson(jsonReader, Issue.class);
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public Issue updateIssue(String issueKey,IssueUpdate issueUpdate) throws IOException, RestException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).build();
        String json = GsonParserUtil.parseObjectToJson(issueUpdate);
        PutMethod method = HttpMethodFactory.createPutMethod(uri, json);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_NO_CONTENT) {
            return getIssueByKey(issueKey);
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public Issue getIssueByKey(String issueKey, List<String> fields, List<String> expand) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        UriBuilder path = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey);
        if (fields != null && fields.isEmpty() == false) {
            String fieldsParam = StringUtils.join(fields, SEPARATOR);
            path.queryParam(FIELDS, fieldsParam);
        }
        if (expand != null && expand.isEmpty() == false) {
            String expandParam = StringUtils.join(expand, SEPARATOR);
            path.queryParam(EXPAND, expandParam);
        }
        URI uri = path.build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonReader jsonReader = toJsonReader(inputStream);
            return (Issue) gson.fromJson(jsonReader, Issue.class);
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public Comments getCommentsByIssue(String issueKey) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(COMMENT).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonReader jsonReader = toJsonReader(inputStream);
            Comments comments = gson.fromJson(jsonReader, Comments.class);
            method.releaseConnection();
            return comments;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public byte[] getAttachment(URI uri) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        GetMethod method = new GetMethod(uri.getPath());
        method.setQueryString(uri.getQuery());
        method.setRequestHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_OCTET_STREAM);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            byte[] bytes = IOUtils.toByteArray(inputStream);
            method.releaseConnection();
            return bytes;
        }
        method.releaseConnection();
        return null;
    }

    @Override
    public InputStream getAttachmentAsStream(long id) {
        return null;
    }

    @Override
    public Attachment getAttachment(long id) throws IOException, RestException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(ATTACHMENT).path(String.valueOf(id)).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonReader jsonReader = toJsonReader(inputStream);
            Attachment attachment = gson.fromJson(jsonReader, Attachment.class);
            method.releaseConnection();
            return attachment;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }


    @Override
    public void saveAttachmentToIssue(File file, String issuekey) {

    }

    @Override
    public boolean transferWorklogInIssue(String issueKey, Worklog worklog) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        String json = gson.toJson(worklog);
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(WORKLOG).build();
        PostMethod method = HttpMethodFactory.createPostMethod(uri, json);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_CREATED) {
            method.releaseConnection();
            return true;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public boolean updateIssueTransitionByKey(String issueKey, int transitionId) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        String json = GsonParserUtil.parseTransitionToJson(transitionId);
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(TRANSITIONS).build();
        PostMethod method = HttpMethodFactory.createPostMethod(uri, json);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_NO_CONTENT) {
            method.releaseConnection();
            return true;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public List<Transition> getIssueTransitionsByKey(String issueKey) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        UriBuilder path = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(TRANSITIONS);
        path.queryParam(EXPAND, TRANSITIONS_FIELDS);
        URI uri = path.build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            JsonElement transitionsElement = jsonObject.get(JsonConstants.PROP_TRANSITIONS);
            if (JsonElementUtil.checkNotNull(transitionsElement)) {
                JsonArray array = transitionsElement.getAsJsonArray();
                Type listType = new TypeToken<ArrayList<Transition>>(){}.getType();
                List<Transition> transitions = gson.fromJson(array, listType);
                method.releaseConnection();
                return transitions;
            }
            method.releaseConnection();
            return Collections.emptyList();
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

}
