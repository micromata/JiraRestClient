package de.micromata.jira.rest.core;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.UserClient;
import de.micromata.jira.rest.core.domain.UserBean;
import de.micromata.jira.rest.core.util.HttpMethodFactory;
import de.micromata.jira.rest.core.util.RestException;
import de.micromata.jira.rest.core.misc.RestParamConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 02.08.2014
 */
public class UserClientImpl extends BaseClient implements UserClient, RestPathConstants, RestParamConstants {

    private JiraRestClient jiraRestClient;

    private HttpClient client;

    public UserClientImpl(JiraRestClient jiraRestClient, ExecutorService executorService) {
        this.jiraRestClient = jiraRestClient;
        this.client = jiraRestClient.getClient();
        this.executorService = executorService;
    }

    @Override
    public Future<List<UserBean>> getAssignableUserForProject(String projectKey, Integer startAt, Integer maxResults) throws RestException, IOException {
        return getAssignableSearch(null, null, projectKey, startAt, maxResults);
    }

    @Override
    public Future<List<UserBean>> getAssignableUsersForIssue(String issueKey, Integer startAt, Integer maxResults) throws RestException, IOException {
        return getAssignableSearch(null, issueKey, null, startAt, maxResults);
    }

    @Override
    public Future<UserBean> getUserByUsername(final String username) throws RestException, IOException {
        Validate.notNull(username);
        return executorService.submit(new Callable<UserBean>() {
            @Override
            public UserBean call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                UriBuilder path = UriBuilder.fromUri(baseUri).path(USER);
                path.queryParam(USERNAME, username);
                URI uri = path.build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    UserBean user = gson.fromJson(jsonReader, UserBean.class);
                    method.releaseConnection();
                    return user;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }


    @Override
    public Future<UserBean> getLoggedInRemoteUser() throws RestException, IOException {
        String username = jiraRestClient.getUsername();
        return getUserByUsername(username);
    }


    private Future<List<UserBean>> getAssignableSearch(final String username, final String issueKey, final String projectKey, final Integer startAt, final Integer maxResults) throws RestException, IOException {
        return executorService.submit(new Callable<List<UserBean>>() {
            @Override
            public List<UserBean> call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                UriBuilder path = UriBuilder.fromUri(baseUri).path(USER).path(ASSIGNABLE).path(SEARCH);
                if(StringUtils.trimToNull(username) != null){
                    path.queryParam(USERNAME, username);
                }
                if(StringUtils.trimToNull(issueKey) != null){
                    path.queryParam(ISSUEKEY, issueKey);
                }
                if(StringUtils.trimToNull(projectKey) != null){
                    path.queryParam(PROJECTKEY, projectKey);
                }
                if(startAt != null && startAt >= 0){
                    path.queryParam(START_AT, startAt);
                }
                if(maxResults != null && maxResults > 0 && maxResults < 1000) {
                    path.queryParam(MAX_RESULTS, maxResults);
                }
                URI uri = path.build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if(status == HttpURLConnection.HTTP_OK){
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<UserBean>>(){}.getType();
                    List<UserBean> users = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    return users;
                }
                else{
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }
}
