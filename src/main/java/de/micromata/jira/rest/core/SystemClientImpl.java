package de.micromata.jira.rest.core;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.SystemClient;
import de.micromata.jira.rest.core.domain.Issuetype;
import de.micromata.jira.rest.core.domain.Priority;
import de.micromata.jira.rest.core.domain.Status;
import de.micromata.jira.rest.core.util.HttpMethodFactory;
import de.micromata.jira.rest.core.util.RestException;
import de.micromata.jira.rest.core.misc.RestParamConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 31.07.2014
 */
public class SystemClientImpl extends BaseClient implements SystemClient, RestParamConstants, RestPathConstants {


    private JiraRestClient jiraRestClient = null;

    private HttpClient client = null;

    private SystemClientImpl() {
    }

    public SystemClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
        this.client = jiraRestClient.getClient();
    }

    @Override
    public List<Issuetype> getIssueTypes() throws RestException, IOException {
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUETPYES).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonReader jsonReader = toJsonReader(inputStream);
            Type listType = new TypeToken<ArrayList<Issuetype>>(){}.getType();
            List<Issuetype> issuetypes = gson.fromJson(jsonReader, listType);
            method.releaseConnection();
            return issuetypes;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public List<Status> getStates() throws RestException, IOException {
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(STATUS).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonReader jsonReader = toJsonReader(inputStream);
            Type listType = new TypeToken<ArrayList<Status>>(){}.getType();
            List<Status> states = gson.fromJson(jsonReader, listType);
            method.releaseConnection();
            return states;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public List<Priority> getPriorities() throws RestException, IOException {
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PRIORITY).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonReader jsonReader = toJsonReader(inputStream);
            Type listType = new TypeToken<ArrayList<Priority>>(){}.getType();
            List<Priority> priorities = gson.fromJson(jsonReader, listType);
            method.releaseConnection();
            return priorities;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }
}
