package de.micromata.jira.rest.core;

import com.google.gson.reflect.TypeToken;
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
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(ISSUE, issueKey);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                return extractIssueBean(method, response);
            }else if(statusCode == HttpURLConnection.HTTP_NOT_FOUND){
                method.releaseConnection();
                response.close();
                return null;
            }
            else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }



    public Future<IssueResponse> createIssue(final IssueBean issue)
            throws RestException, IOException {
        Validate.notNull(issue);
        return executorService.submit(() -> {

            String json = gson.toJson(issue);
            URIBuilder uriBuilder = buildPath(ISSUE);
            HttpPost method = HttpMethodFactory.createPostMethod(uriBuilder.build(),
                    json);
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK
                    || statusCode == HttpURLConnection.HTTP_CREATED) {
                JsonReader jsonReader = getJsonReader(response);
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
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });

    }

    public Future<IssueBean> updateIssue(final String issueKey,
                                         final IssueUpdate issueUpdate) throws IOException, RestException {

        Validate.notNull(issueKey);
        Validate.notNull(issueUpdate);
        return executorService.submit(() -> {

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
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }

    public Future<IssueBean> getIssueByKey(final String issueKey,
                                           final List<String> fields, final List<String> expand)
            throws RestException, IOException {

        return executorService.submit(() -> {

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
                return extractIssueBean(method, response);
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }

    public Future<CommentsBean> getCommentsByIssue(final String issueKey)
            throws RestException, IOException {

        Validate.notNull(issueKey);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(ISSUE, issueKey, COMMENT);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                CommentsBean comments = gson.fromJson(jsonReader,
                        CommentsBean.class);
                method.releaseConnection();
                response.close();
                return comments;
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }

    public Future<Byte[]> getAttachment(final URI uri) throws RestException,
            IOException {

        Validate.notNull(uri);
        return executorService.submit(() -> {
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
        });
    }

    public InputStream getAttachmentAsStream(long id) {
        return null;
    }

    public Future<AttachmentBean> getAttachment(final long id)
            throws IOException, RestException {

        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(ATTACHMENT, String.valueOf(id));
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                AttachmentBean attachment = gson.fromJson(jsonReader,
                        AttachmentBean.class);
                method.releaseConnection();
                response.close();
                return attachment;
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });

    }

    public Future<List<AttachmentBean>> saveAttachmentToIssue(String issuekey,File... files) throws URISyntaxException, IOException, RestException {

        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUE, issuekey, ATTACHMENTS);
            HttpPost postMethod = new HttpPost(uriBuilder.build());
            postMethod.setHeader("X-Atlassian-Token", "no-check");
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            for (File file : files) {
                FileBody fileBody = new FileBody(file, ContentType.MULTIPART_FORM_DATA);
                multipartEntityBuilder.addPart("file", fileBody);
            }
            HttpEntity entity = multipartEntityBuilder.build();
            postMethod.setEntity(entity);
            CloseableHttpResponse response = client.execute(postMethod);
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpURLConnection.HTTP_OK){
                JsonReader jsonReader = getJsonReader(response);
                Type listType = new TypeToken<ArrayList<AttachmentBean>>() {
                }.getType();
                List<AttachmentBean> attachments = gson.fromJson(jsonReader, listType);
                postMethod.releaseConnection();
                response.close();
                return attachments;
            }else{
                RestException restException = new RestException(response);
                postMethod.releaseConnection();
                response.close();
                throw restException;
            }
        });
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
            RestException restException = new RestException(response);
            method.releaseConnection();
            response.close();
            throw restException;
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
            RestException restException = new RestException(response);
            method.releaseConnection();
            response.close();
            throw restException;
        }
    }

    public Future<List<TransitionBean>> getIssueTransitionsByKey(
            final String issueKey) throws RestException, IOException {

        Validate.notNull(issueKey);
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUE, issueKey, TRANSITIONS);
            uriBuilder.addParameter(EXPAND, TRANSITIONS_FIELDS);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                final IssueBean issueBean = extractIssueBean(method, response);
                return issueBean.getTransitions();
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }

    private IssueBean extractIssueBean(HttpGet method, CloseableHttpResponse response) throws IOException {
        JsonReader jsonReader = getJsonReader(response);
        final IssueBean issueBean = gson.fromJson(jsonReader,
                IssueBean.class);
        method.releaseConnection();
        response.close();
        return issueBean;
    }
}
