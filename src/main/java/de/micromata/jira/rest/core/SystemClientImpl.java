package de.micromata.jira.rest.core;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.SystemClient;
import de.micromata.jira.rest.core.domain.IssuetypeBean;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.StatusBean;
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
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

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
    public Future<List<IssuetypeBean>> getIssueTypes() throws RestException, IOException {
        return executorService.submit(new Callable<List<IssuetypeBean>>() {
            @Override
            public List<IssuetypeBean> call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(ISSUETPYES).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<IssuetypeBean>>(){}.getType();
                    List<IssuetypeBean> issuetypes = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    return issuetypes;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });

    }

    @Override
    public Future<List<StatusBean>> getStates() throws RestException, IOException {
        return executorService.submit(new Callable<List<StatusBean>>() {
            @Override
            public List<StatusBean> call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(STATUS).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<StatusBean>>(){}.getType();
                    List<StatusBean> states = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    return states;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });

    }

    @Override
    public Future<List<PriorityBean>> getPriorities() throws RestException, IOException {
        return executorService.submit(new Callable<List<PriorityBean>>() {
            @Override
            public List<PriorityBean> call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(PRIORITY).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<PriorityBean>>(){}.getType();
                    List<PriorityBean> priorities = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    return priorities;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }
}
