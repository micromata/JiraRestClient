package de.micromata.jira.rest.core;

import com.google.gson.JsonObject;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.ProjectClient;
import de.micromata.jira.rest.core.domain.BasicProjectBean;
import de.micromata.jira.rest.core.domain.ComponentBean;
import de.micromata.jira.rest.core.domain.ProjectBean;
import de.micromata.jira.rest.core.domain.VersionBean;
import de.micromata.jira.rest.core.parser.BasicProjectParser;
import de.micromata.jira.rest.core.parser.ComponentParser;
import de.micromata.jira.rest.core.parser.ProjectParser;
import de.micromata.jira.rest.core.parser.VersionParser;
import de.micromata.jira.rest.core.util.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/**
 * Author: Christian
 * Date: 31.07.2014
 */
public class ProjectClientImpl implements ProjectClient, RestParamConstants, RestPathConstants {


    private JiraRestClient jiraRestClient = null;

    private ProjectClientImpl() {
    }

    public ProjectClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
    }


    @Override
    public ProjectBean getProjectByKey(String projectKey) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).path(projectKey).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            method.releaseConnection();
            return ProjectParser.parse(jsonObject);
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public List<BasicProjectBean> getAllProjects() throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            List<JsonObject> jsonObjects = GsonParserUtil.parseJsonObjects(inputStream);
            List<BasicProjectBean> beans = BasicProjectParser.parseBasicProject(jsonObjects);
            method.releaseConnection();
            Collections.sort(beans);
            return beans;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }


    @Override
    public List<VersionBean> getProjectVersions(String projectKey) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).path(projectKey).path(VERSIONS).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<VersionBean> parse = VersionParser.parse(objects);
            method.releaseConnection();
            Collections.sort(parse);
            return parse;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public List<ComponentBean> getProjectComponents(String projectKey) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).path(projectKey).path(COMPONENTS).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);

        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<ComponentBean> parse = ComponentParser.parse(objects);
            method.releaseConnection();
            Collections.sort(parse);
            return parse;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public ComponentBean getComponentById(long id) throws RestException {
        return null;
    }

    @Override
    public VersionBean getVersionById(long id) throws RestException {
        return null;
    }

    @Override
    public ComponentBean updateComponent(ComponentBean componentBean) throws RestException {
        return null;
    }

    @Override
    public VersionBean updateVersion(VersionBean versionBean) throws RestException {
        return null;
    }
}
