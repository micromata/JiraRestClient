package de.micromata.jira.rest.core;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.UserClient;
import de.micromata.jira.rest.core.domain.UserBean;
import de.micromata.jira.rest.core.domain.permission.MyPermissionsBean;
import de.micromata.jira.rest.core.misc.RestParamConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import de.micromata.jira.rest.core.util.HttpMethodFactory;
import de.micromata.jira.rest.core.util.RestException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
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

    public UserClientImpl(JiraRestClient jiraRestClient, ExecutorService executorService) {
        super(jiraRestClient);
        this.executorService = executorService;
    }


    public Future<List<UserBean>> getAssignableUserForProject(String projectKey, Integer startAt, Integer maxResults) throws RestException, IOException {
        return getAssignableSearch(null, null, projectKey, startAt, maxResults);
    }


    public Future<List<UserBean>> getAssignableUsersForIssue(String issueKey, Integer startAt, Integer maxResults) throws RestException, IOException {
        return getAssignableSearch(null, issueKey, null, startAt, maxResults);
    }


    public Future<UserBean> getUserByUsername(final String username) throws RestException, IOException {
        Validate.notNull(username);
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(USER);
            uriBuilder.addParameter(USERNAME, username);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                UserBean user = gson.fromJson(jsonReader, UserBean.class);
                method.releaseConnection();
                return user;
            } else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN) {
                return null;
            } else {
                RestException restException = new RestException(response);
                response.close();
                method.releaseConnection();
                throw restException;
            }
        });
    }


    public Future<UserBean> getLoggedInRemoteUser() throws RestException, IOException {
        String username = jiraRestClient.getUsername();
        return getUserByUsername(username);
    }

    @Override
    public Future<MyPermissionsBean> getMyPermissions() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(MYPERMISSIONS);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                MyPermissionsBean permissionsBean = gson.fromJson(jsonReader, MyPermissionsBean.class);
                method.releaseConnection();
                return permissionsBean;
            } else {
                RestException restException = new RestException(response);
                response.close();
                method.releaseConnection();
                throw restException;
            }
        });
    }


    private Future<List<UserBean>> getAssignableSearch(final String username, final String issueKey, final String projectKey, final Integer startAt, final Integer maxResults) throws RestException, IOException {

        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(USER, ASSIGNABLE, SEARCH);
            if (StringUtils.trimToNull(username) != null) {
                uriBuilder.addParameter(USERNAME, username);
            }
            if (StringUtils.trimToNull(issueKey) != null) {
                uriBuilder.addParameter(ISSUEKEY, issueKey);
            }
            if (StringUtils.trimToNull(projectKey) != null) {
                uriBuilder.addParameter(PROJECTKEY, projectKey);
            }
            if (startAt != null && startAt >= 0) {
                uriBuilder.addParameter(START_AT, startAt.toString());
            }
            if (maxResults != null && maxResults > 0 && maxResults < 1000) {
                uriBuilder.addParameter(MAX_RESULTS, maxResults.toString());
            }
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                Type listType = new TypeToken<ArrayList<UserBean>>() {
                }.getType();
                List<UserBean> users = gson.fromJson(jsonReader, listType);
                method.releaseConnection();
                return users;
            } else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN) {
                return new ArrayList<>();
            } else {
                RestException restException = new RestException(response);
                response.close();
                method.releaseConnection();
                throw restException;
            }
        });
    }
}
