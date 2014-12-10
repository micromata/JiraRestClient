package de.micromata.jira.rest.core;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.ProjectClient;
import de.micromata.jira.rest.core.domain.*;
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
 * User: Christian
 * Date: 31.07.2014
 */
public class ProjectClientImpl extends BaseClient implements ProjectClient, RestParamConstants, RestPathConstants {


    private JiraRestClient jiraRestClient = null;

    private ProjectClientImpl() {
    }

    public ProjectClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
    }


    @Override
    public Project getProjectByKey(String projectKey) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).path(projectKey).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonReader jsonReader = toJsonReader(inputStream);
            Project project = gson.fromJson(jsonReader, Project.class);
            method.releaseConnection();
            return project;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public List<Project> getAllProjects() throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonReader jsonReader = toJsonReader(inputStream);
            Type listType = new TypeToken<ArrayList<Project>>(){}.getType();
            List<Project> projects = gson.fromJson(jsonReader, listType);
            method.releaseConnection();
            return projects;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }


    @Override
    public List<Version> getProjectVersions(String projectKey) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).path(projectKey).path(VERSIONS).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonReader jsonReader = toJsonReader(inputStream);
            Type listType = new TypeToken<ArrayList<Version>>(){}.getType();
            List<Version> versions = gson.fromJson(jsonReader, listType);
            method.releaseConnection();
            return versions;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public List<Component> getProjectComponents(String projectKey) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).path(projectKey).path(COMPONENTS).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);

        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonReader jsonReader = toJsonReader(inputStream);
            Type listType = new TypeToken<ArrayList<Component>>(){}.getType();
            List<Component> components = gson.fromJson(jsonReader, listType);
            method.releaseConnection();
            return components;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

}
