package de.micromata.jira.rest.core;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.ProjectClient;
import de.micromata.jira.rest.core.domain.ComponentBean;
import de.micromata.jira.rest.core.domain.ProjectBean;
import de.micromata.jira.rest.core.domain.VersionBean;
import de.micromata.jira.rest.core.domain.meta.MetaBean;
import de.micromata.jira.rest.core.misc.RestParamConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import de.micromata.jira.rest.core.util.HttpMethodFactory;
import de.micromata.jira.rest.core.util.RestException;
import org.apache.commons.lang3.Validate;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * User: Christian
 * Date: 31.07.2014
 */
public class ProjectClientImpl extends BaseClient implements ProjectClient, RestParamConstants, RestPathConstants {


    public ProjectClientImpl(JiraRestClient jiraRestClient, ExecutorService executorService) {
        super(jiraRestClient);
        this.executorService = executorService;
    }

    public Future<ProjectBean> getProjectByKey(final String projectKey) throws RestException, IOException {
        Validate.notNull(projectKey);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PROJECT, projectKey);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                ProjectBean project = gson.fromJson(jsonReader, ProjectBean.class);
                method.releaseConnection();
                response.close();
                return project;
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });

    }


    public Future<List<ProjectBean>> getAllProjects() throws RestException, IOException {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PROJECT);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                Type listType = new TypeToken<ArrayList<ProjectBean>>() {
                }.getType();
                List<ProjectBean> projects = gson.fromJson(jsonReader, listType);
                method.releaseConnection();
                response.close();
                return projects;
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }


    public Future<List<VersionBean>> getProjectVersions(final String projectKey) throws RestException, IOException {
        Validate.notNull(projectKey);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PROJECT, projectKey, VERSIONS);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                Type listType = new TypeToken<ArrayList<VersionBean>>() {
                }.getType();
                List<VersionBean> versions = gson.fromJson(jsonReader, listType);
                method.releaseConnection();
                response.close();
                return versions;
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }


    public Future<List<ComponentBean>> getProjectComponents(final String projectKey) throws RestException, IOException {
        Validate.notNull(projectKey);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PROJECT, projectKey, COMPONENTS);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                Type listType = new TypeToken<ArrayList<ComponentBean>>() {
                }.getType();
                List<ComponentBean> components = gson.fromJson(jsonReader, listType);
                method.releaseConnection();
                response.close();
                return components;
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }

    @Override
    public Future<MetaBean> getIssueTypesMetaForProject(final String projectKey) {
        Validate.notNull(projectKey);
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUE, CREATEMETA);
            uriBuilder.addParameter(PROJECTKEYS, projectKey);
            uriBuilder.addParameter(EXPAND, "projects.issuetypes.fields");
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                MetaBean metabean = gson.fromJson(jsonReader, MetaBean.class);
                method.releaseConnection();
                response.close();
                return metabean;
            }else{
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }
}
