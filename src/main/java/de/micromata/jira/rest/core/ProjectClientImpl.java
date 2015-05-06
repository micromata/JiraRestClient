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
import org.apache.commons.lang3.Validate;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
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


    public ProjectClientImpl(JiraRestClient jiraRestClient, ExecutorService executorService) {
        super(jiraRestClient);
        this.executorService = executorService;
    }

    public Future<ProjectBean> getProjectByKey(final String projectKey) throws RestException, IOException {
        Validate.notNull(projectKey);
        return executorService.submit(new Callable<ProjectBean>() {
            public ProjectBean call() throws Exception {

                URIBuilder uriBuilder = buildPath(PROJECT, projectKey);
                HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    ProjectBean project = gson.fromJson(jsonReader, ProjectBean.class);
                    response.close();
                    return project;
                } else {
                    response.close();
                    throw new RestException(response);
                }
            }
        });

    }


    public Future<List<ProjectBean>> getAllProjects() throws RestException, IOException {
        return executorService.submit(new Callable<List<ProjectBean>>() {

            public List<ProjectBean> call() throws Exception {

                URIBuilder uriBuilder = buildPath(PROJECT);
                HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<ProjectBean>>() {
                    }.getType();
                    List<ProjectBean> projects = gson.fromJson(jsonReader, listType);
                    response.close();
                    return projects;
                } else {
                    response.close();
                    throw new RestException(response);
                }
            }
        });
    }


    public Future<List<VersionBean>> getProjectVersions(final String projectKey) throws RestException, IOException {
        Validate.notNull(projectKey);
        return executorService.submit(new Callable<List<VersionBean>>() {

            public List<VersionBean> call() throws Exception {

                URIBuilder uriBuilder = buildPath(PROJECT, projectKey, VERSIONS);
                HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<VersionBean>>() {
                    }.getType();
                    List<VersionBean> versions = gson.fromJson(jsonReader, listType);
                    response.close();
                    return versions;
                } else {
                    response.close();
                    throw new RestException(response);
                }
            }
        });
    }


    public Future<List<ComponentBean>> getProjectComponents(final String projectKey) throws RestException, IOException {
        Validate.notNull(projectKey);
        return executorService.submit(new Callable<List<ComponentBean>>() {

            public List<ComponentBean> call() throws Exception {

                URIBuilder uriBuilder = buildPath(PROJECT, projectKey, COMPONENTS);
                HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<ComponentBean>>() {
                    }.getType();
                    List<ComponentBean> components = gson.fromJson(jsonReader, listType);
                    response.close();
                    return components;
                } else {
                    response.close();
                    throw new RestException(response);
                }
            }
        });
    }
}
