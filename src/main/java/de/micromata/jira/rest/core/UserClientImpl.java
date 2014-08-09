package de.micromata.jira.rest.core;

import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.UserClient;
import de.micromata.jira.rest.core.domain.UserBean;
import de.micromata.jira.rest.core.parser.UserParser;
import de.micromata.jira.rest.core.util.GsonParserUtil;
import de.micromata.jira.rest.core.util.RestParamConstants;
import de.micromata.jira.rest.core.util.RestPathConstants;
import de.micromata.jira.rest.core.util.RestException;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 02.08.2014
 */
public class UserClientImpl implements UserClient, RestPathConstants, RestParamConstants {

    private JiraRestClient jiraRestClient;

    private UserClientImpl() {
    }

    public UserClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
    }

    @Override
    public List<UserBean> getAssignableUserForProject(String projectKey, Integer startAt, Integer maxResults) throws RestException {
        return getAssignableSearch(null, null, projectKey, startAt, maxResults);
    }

    @Override
    public List<UserBean> getAssignableUsersForIssue(String issueKey, Integer startAt, Integer maxResults) throws RestException {
        return getAssignableSearch(null, issueKey, null, startAt, maxResults);
    }

    @Override
    public UserBean getUserByUsername(String username) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        UriBuilder path = UriBuilder.fromUri(baseUri).path(USER);
        path.queryParam(USERNAME, username);
        URI uri = path.build();
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
    public UserBean getLoggedInRemoteUser() throws RestException {
        String username = jiraRestClient.getUsername();
        return getUserByUsername(username);
    }


    private List<UserBean> getAssignableSearch(String username, String issueKey, String projectKey, Integer startAt, Integer maxResults) throws RestException {
        Client client = jiraRestClient.getClient();
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
            path.queryParam(START_AT, startAt.intValue());
        }
        if(maxResults != null && maxResults > 0 && maxResults < 1000) {
            path.queryParam(MAX_RESULTS, maxResults.intValue());
        }
        URI uri = path.build();
        WebResource webResource = client.resource(uri);
        ClientResponse response = webResource.get(ClientResponse.class);
        if(response != null && response.getStatus() == HttpURLConnection.HTTP_OK){
            InputStream inputStream = response.getEntityInputStream();
            List<JsonObject> jsonObjects = GsonParserUtil.parseJsonObjects(inputStream);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.close();
            return UserParser.parse(jsonObjects);
        }
        else{
            throw new RestException(response);
        }
    }
}
