package de.micromata.jira.rest.core;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.ProjectClient;
import de.micromata.jira.rest.core.domain.ComponentBean;
import de.micromata.jira.rest.core.domain.ProjectBean;
import de.micromata.jira.rest.core.domain.VersionBean;
import de.micromata.jira.rest.core.misc.RestParamConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import de.micromata.jira.rest.core.util.HttpMethodFactory;
import de.micromata.jira.rest.core.util.RestException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
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
 * User: Christian
 * Date: 31.07.2014
 */
public class ProjectClientImpl extends BaseClient implements ProjectClient, RestParamConstants, RestPathConstants {


    private JiraRestClient jiraRestClient = null;

    private HttpClient client;

    public ProjectClientImpl(JiraRestClient jiraRestClient, ExecutorService executorService) {
        this.jiraRestClient = jiraRestClient;
        this.client = jiraRestClient.getClient();
        this.executorService = executorService;
    }


    @Override
    public Future<ProjectBean> getProjectByKey(final String projectKey) throws RestException, IOException {
        Validate.notNull(projectKey);
        return executorService.submit(new Callable<ProjectBean>() {
            @Override
            public ProjectBean call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).path(projectKey).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    ProjectBean project = gson.fromJson(jsonReader, ProjectBean.class);
                    method.releaseConnection();
                    return project;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });

    }

    @Override
    public Future<List<ProjectBean>> getAllProjects() throws RestException, IOException {
        return executorService.submit(new Callable<List<ProjectBean>>() {
            @Override
            public List<ProjectBean> call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<ProjectBean>>() {
                    }.getType();
                    List<ProjectBean> projects = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    return projects;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }


    @Override
    public Future<List<VersionBean>> getProjectVersions(final String projectKey) throws RestException, IOException {
        Validate.notNull(projectKey);
        return executorService.submit(new Callable<List<VersionBean>>() {
            @Override
            public List<VersionBean> call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).path(projectKey).path(VERSIONS).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<VersionBean>>() {
                    }.getType();
                    List<VersionBean> versions = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    return versions;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }

    @Override
    public Future<List<ComponentBean>> getProjectComponents(final String projectKey) throws RestException, IOException {
        Validate.notNull(projectKey);
        return executorService.submit(new Callable<List<ComponentBean>>() {
            @Override
            public List<ComponentBean> call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).path(projectKey).path(COMPONENTS).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);

                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<ComponentBean>>() {
                    }.getType();
                    List<ComponentBean> components = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    return components;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }
}
