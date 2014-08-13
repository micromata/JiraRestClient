package de.micromata.jira.rest.core;

import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.ProjectClient;
import de.micromata.jira.rest.core.domain.*;
import de.micromata.jira.rest.core.parser.BasicProjectParser;
import de.micromata.jira.rest.core.parser.ComponentParser;
import de.micromata.jira.rest.core.parser.ProjectParser;
import de.micromata.jira.rest.core.parser.VersionParser;
import de.micromata.jira.rest.core.util.*;

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
    public ProjectBean getProjectByKey(String projectKey) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).path(projectKey).build();
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
            return ProjectParser.parse(jsonObject);
        } else {
            throw new RestException(response);
        }
    }

    @Override
    public List<BasicProjectBean> getAllProjects() throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).build();
        WebResource webResource = client.resource(uri);
        ClientResponse response = webResource.get(ClientResponse.class);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = response.getEntityInputStream();
            List<JsonObject> jsonObjects = GsonParserUtil.parseJsonObjects(inputStream);
            List<BasicProjectBean> beans = BasicProjectParser.parseBasicProject(jsonObjects);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.close();
            Collections.sort(beans);
            return beans;
        } else {
            throw new RestException(response);
        }
    }


    @Override
    public List<VersionBean> getProjectVersions(String projectKey) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).path(projectKey).path(VERSIONS).build();
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.get(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<VersionBean> parse = VersionParser.parse(objects);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientResponse.close();
            Collections.sort(parse);
            return parse;
        } else {
            clientResponse.close();
            throw new RestException(clientResponse);
        }
    }

    @Override
    public List<ComponentBean> getProjectComponents(String projectKey) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(PROJECT).path(projectKey).path(COMPONENTS).build();
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.get(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<ComponentBean> parse = ComponentParser.parse(objects);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientResponse.close();
            Collections.sort(parse);
            return parse;
        } else {
            throw new RestException(clientResponse);
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
