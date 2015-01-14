package de.micromata.jira.rest.core;

import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.IssueClient;
import de.micromata.jira.rest.core.domain.*;
import de.micromata.jira.rest.core.domain.update.IssueUpdate;
import de.micromata.jira.rest.core.misc.RestParamConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import de.micromata.jira.rest.core.util.GsonParserUtil;
import de.micromata.jira.rest.core.util.HttpMethodFactory;
import de.micromata.jira.rest.core.util.RestException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * User: Christian
 * Date: ${Date}
 */
public class IssueClientImpl extends BaseClient implements IssueClient, RestParamConstants, RestPathConstants {

    private static final String SEPARATOR = ",";
    private JiraRestClient jiraRestClient = null;

    public IssueClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
    }


    @Override
    public Future<IssueResponse> createIssue(final IssueBean issue)
            throws RestException, IOException {
        return executorService.submit(new Callable<IssueResponse>() {
            @Override
            public IssueResponse call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                URI baseUri = jiraRestClient.getBaseUri();
                String json = gson.toJson(issue);
                URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).build();
                PostMethod method = HttpMethodFactory.createPostMethod(uri, json);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK || status == HttpURLConnection.HTTP_CREATED) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    IssueBean issuebean = gson.fromJson(jsonReader, IssueBean.class);
                    return new IssueResponse(issuebean.getKey());
                } else if (status == HttpURLConnection.HTTP_BAD_REQUEST) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    ErrorBean error = gson.fromJson(jsonReader, ErrorBean.class);
                    method.releaseConnection();
                    return new IssueResponse(error);
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });

    }

    @Override
    public Future<IssueBean> getIssueByKey(final String issueKey) throws RestException, IOException {
        return executorService.submit(new Callable<IssueBean>() {
            @Override
            public IssueBean call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    return (IssueBean) gson.fromJson(jsonReader, IssueBean.class);
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });

    }

    @Override
    public Future<IssueBean> updateIssue(final String issueKey, final IssueUpdate issueUpdate) throws IOException, RestException {
        return executorService.submit(new Callable<IssueBean>() {
            @Override
            public IssueBean call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).build();
                String json = gson.toJson(issueUpdate);
                PutMethod method = HttpMethodFactory.createPutMethod(uri, json);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_NO_CONTENT) {
                    final Future<IssueBean> issueByKey = getIssueByKey(issueKey);
                    while(issueByKey.isDone()){
                        return issueByKey.get();
                    }
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
                return null;
            }
        });
    }

    @Override
    public Future<IssueBean> getIssueByKey(final String issueKey, final List<String> fields, final List<String> expand) throws RestException, IOException {
        return executorService.submit(new Callable<IssueBean>() {
            @Override
            public IssueBean call() throws Exception {
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
                    return (IssueBean) gson.fromJson(jsonReader, IssueBean.class);
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }

    @Override
    public Future<CommentsBean> getCommentsByIssue(final String issueKey) throws RestException, IOException {
        return executorService.submit(new Callable<CommentsBean>() {
            @Override
            public CommentsBean call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(COMMENT).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    CommentsBean comments = gson.fromJson(jsonReader, CommentsBean.class);
                    method.releaseConnection();
                    return comments;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }

    @Override
    public Future<Byte[]> getAttachment(final URI uri) throws RestException, IOException {
        return executorService.submit(new Callable<Byte[]>() {
            @Override
            public Byte[] call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                GetMethod method = new GetMethod(uri.getPath());
                method.setQueryString(uri.getQuery());
                method.setRequestHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_OCTET_STREAM);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    method.releaseConnection();
                    return ArrayUtils.toObject(bytes);
                }
                method.releaseConnection();
                return null;
            }
        });
    }

    @Override
    public InputStream getAttachmentAsStream(long id) {
        return null;
    }

    @Override
    public Future<AttachmentBean> getAttachment(final long id) throws IOException, RestException {
        return executorService.submit(new Callable<AttachmentBean>() {
            @Override
            public AttachmentBean call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(ATTACHMENT).path(String.valueOf(id)).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    AttachmentBean attachment = gson.fromJson(jsonReader, AttachmentBean.class);
                    method.releaseConnection();
                    return attachment;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });

    }


    @Override
    public void saveAttachmentToIssue(File file, String issuekey) {

    }

    @Override
    public boolean transferWorklogInIssue(String issueKey, WorklogBean worklog) throws RestException, IOException {
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
    public Future<List<TransitionBean>> getIssueTransitionsByKey(final String issueKey) throws RestException, IOException {
        return executorService.submit(new Callable<List<TransitionBean>>() {
            @Override
            public List<TransitionBean> call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                URI baseUri = jiraRestClient.getBaseUri();
                UriBuilder path = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(TRANSITIONS);
                path.queryParam(EXPAND, TRANSITIONS_FIELDS);
                URI uri = path.build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    final IssueBean issueBean = gson.fromJson(jsonReader, IssueBean.class);
                    method.releaseConnection();
                    return issueBean.getTransitions();
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }
}
