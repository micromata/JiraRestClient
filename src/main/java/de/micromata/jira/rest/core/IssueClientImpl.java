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
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * User: Christian Date: ${Date}
 */
public class IssueClientImpl extends BaseClient implements IssueClient,
        RestParamConstants, RestPathConstants {

    private static final String SEPARATOR = ",";

    public IssueClientImpl(JiraRestClient jiraRestClient, ExecutorService executorService) {
        super(jiraRestClient);
        this.executorService = executorService;
    }

    public Future<IssueBean> getIssueByKey(final String issueKey) throws RestException, IOException {
        Validate.notNull(issueKey);
        return executorService.submit(new Callable<IssueBean>() {

            public IssueBean call() throws Exception {
                
                URIBuilder uriBuilder = buildPath(ISSUE, issueKey);
                HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    final IssueBean issueBean = gson.fromJson(jsonReader,
                            IssueBean.class);
                    method.releaseConnection();
                    response.close();
                    return issueBean;
                }else if(statusCode == HttpURLConnection.HTTP_NOT_FOUND){
                    method.releaseConnection();
                    response.close();
                    return null;
                }
                else {
                    method.releaseConnection();
                    response.close();
                    throw new RestException(response);
                }
            }
        });
    }

    public Future<IssueResponse> createIssue(final IssueBean issue)
            throws RestException, IOException {
        Validate.notNull(issue);
        return executorService.submit(new Callable<IssueResponse>() {
            public IssueResponse call() throws Exception {
                
                String json = gson.toJson(issue);
                URIBuilder uriBuilder = buildPath(ISSUE);
                HttpPost method = HttpMethodFactory.createPostMethod(uriBuilder.build(),
                        json);
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK
                        || statusCode == HttpURLConnection.HTTP_CREATED) {
                    HttpEntity entity = response.getEntity();
                    InputStream content = entity.getContent();
                    JsonReader jsonReader = toJsonReader(content);
                    IssueBean issueBean = gson.fromJson(jsonReader,
                            IssueBean.class);
                    method.releaseConnection();
                    response.close();
                    return new IssueResponse(issueBean.getKey());
                } else if (statusCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    ErrorBean error = gson
                            .fromJson(jsonReader, ErrorBean.class);
                    method.releaseConnection();
                    response.close();
                    return new IssueResponse(error);
                } else {
                    method.releaseConnection();
                    response.close();
                    throw new RestException(response);
                }
            }
        });

    }

    public Future<IssueBean> updateIssue(final String issueKey,
                                         final IssueUpdate issueUpdate) throws IOException, RestException {

        Validate.notNull(issueKey);
        Validate.notNull(issueUpdate);
        return executorService.submit(new Callable<IssueBean>() {

            public IssueBean call() throws Exception {
                
                URIBuilder uriBuilder = buildPath(ISSUE, issueKey);
                String json = gson.toJson(issueUpdate);
                HttpPut method = HttpMethodFactory.createPutMethod(uriBuilder.build(), json);
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_NO_CONTENT) {
                    final Future<IssueBean> issueByKey = getIssueByKey(issueKey);
                    method.releaseConnection();
                    response.close();
                    return issueByKey.get();
                } else {
                    method.releaseConnection();
                    response.close();
                    throw new RestException(response);
                }
            }
        });
    }

    public Future<IssueBean> getIssueByKey(final String issueKey,
                                           final List<String> fields, final List<String> expand)
            throws RestException, IOException {

        return executorService.submit(new Callable<IssueBean>() {

            public IssueBean call() throws Exception {
                
                URIBuilder uriBuilder = buildPath(ISSUE, issueKey);
                if (fields != null && fields.isEmpty() == false) {
                    String fieldsParam = StringUtils.join(fields, SEPARATOR);
                    uriBuilder.addParameter(FIELDS, fieldsParam);
                }
                if (expand != null && expand.isEmpty() == false) {
                    String expandParam = StringUtils.join(expand, SEPARATOR);
                    uriBuilder.addParameter(EXPAND, expandParam);
                }
                HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    IssueBean issueBean = gson.fromJson(jsonReader,
                            IssueBean.class);
                    method.releaseConnection();
                    response.close();
                    return issueBean;
                } else {
                    method.releaseConnection();
                    response.close();
                    throw new RestException(response);
                }
            }
        });
    }

    public Future<CommentsBean> getCommentsByIssue(final String issueKey)
            throws RestException, IOException {

        Validate.notNull(issueKey);
        return executorService.submit(new Callable<CommentsBean>() {

            public CommentsBean call() throws Exception {
                
                URIBuilder uriBuilder = buildPath(ISSUE, issueKey, COMMENT);
                HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    CommentsBean comments = gson.fromJson(jsonReader,
                            CommentsBean.class);
                    method.releaseConnection();
                    response.close();
                    return comments;
                } else {
                    method.releaseConnection();
                    response.close();
                    throw new RestException(response);
                }
            }
        });
    }

    public Future<Byte[]> getAttachment(final URI uri) throws RestException,
            IOException {

        Validate.notNull(uri);
        return executorService.submit(new Callable<Byte[]>() {

            public Byte[] call() throws Exception {
                HttpGet method = HttpMethodFactory.createHttpGetForFile(uri);
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    method.releaseConnection();
                    response.close();
                    return ArrayUtils.toObject(bytes);
                }
                method.releaseConnection();
                response.close();
                return null;
            }
        });
    }

    public InputStream getAttachmentAsStream(long id) {
        return null;
    }

    public Future<AttachmentBean> getAttachment(final long id)
            throws IOException, RestException {

        return executorService.submit(new Callable<AttachmentBean>() {

            public AttachmentBean call() throws Exception {
                
                URIBuilder uriBuilder = buildPath(ATTACHMENT, String.valueOf(id));
                HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    AttachmentBean attachment = gson.fromJson(jsonReader,
                            AttachmentBean.class);
                    method.releaseConnection();
                    response.close();
                    return attachment;
                } else {
                    method.releaseConnection();
                    response.close();
                    throw new RestException(response);
                }
            }
        });

    }

    public void saveAttachmentToIssue(File file, String issuekey) {

    }

    public boolean transferWorklogInIssue(String issueKey, WorklogBean worklog)
            throws RestException, IOException, URISyntaxException {

        Validate.notNull(issueKey);
        Validate.notNull(worklog);
        
        String json = gson.toJson(worklog);
        URIBuilder uriBuilder = buildPath(ISSUE, issueKey, WORKLOG);
        HttpPost method = HttpMethodFactory.createPostMethod(uriBuilder.build(), json);
        CloseableHttpResponse response = client.execute(method, clientContext);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == HttpURLConnection.HTTP_CREATED) {
            method.releaseConnection();
            response.close();
            return true;
        } else {
            method.releaseConnection();
            response.close();
            throw new RestException(response);
        }
    }

    public boolean updateIssueTransitionByKey(String issueKey, int transitionId)
            throws RestException, IOException, URISyntaxException {

        Validate.notNull(issueKey);
        
        // TODO cs +++ GsonParserUtil entfernen
        String json = GsonParserUtil.parseTransitionToJson(transitionId);
        URIBuilder uriBuilder = buildPath(ISSUE, issueKey, TRANSITIONS);
        HttpPost method = HttpMethodFactory.createPostMethod(uriBuilder.build(), json);
        CloseableHttpResponse response = client.execute(method, clientContext);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == HttpURLConnection.HTTP_NO_CONTENT) {
            method.releaseConnection();
            response.close();
            return true;
        } else {
            method.releaseConnection();
            response.close();
            throw new RestException(response);
        }
    }

    public Future<List<TransitionBean>> getIssueTransitionsByKey(
            final String issueKey) throws RestException, IOException {

        Validate.notNull(issueKey);
        return executorService.submit(new Callable<List<TransitionBean>>() {

            public List<TransitionBean> call() throws Exception {
                URIBuilder uriBuilder = buildPath(ISSUE, issueKey, TRANSITIONS);
                uriBuilder.addParameter(EXPAND, TRANSITIONS_FIELDS);
                HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    final IssueBean issueBean = gson.fromJson(jsonReader,
                            IssueBean.class);
                    method.releaseConnection();
                    response.close();
                    return issueBean.getTransitions();
                } else {
                    method.releaseConnection();
                    response.close();
                    throw new RestException(response);
                }
            }
        });
    }
}
