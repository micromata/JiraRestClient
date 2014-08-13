package de.micromata.jira.rest.core;

import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.SystemClient;
import de.micromata.jira.rest.core.domain.IssueTypeBean;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.StatusBean;
import de.micromata.jira.rest.core.parser.IssueTypeParser;
import de.micromata.jira.rest.core.parser.PriorityParser;
import de.micromata.jira.rest.core.parser.StatusParser;
import de.micromata.jira.rest.core.util.*;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 31.07.2014
 */
public class SystemClientImpl implements SystemClient, RestParamConstants, RestPathConstants {


    private JiraRestClient jiraRestClient = null;

    private SystemClientImpl() {
    }

    public SystemClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
    }

    @Override
    public List<IssueTypeBean> getIssueTypes() throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUETPYES).build();
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.get(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<IssueTypeBean> parse = IssueTypeParser.parse(objects);
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
    public List<StatusBean> getStates() throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(STATUS).build();
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.get(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<StatusBean> parse = StatusParser.parse(objects);
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
    public List<PriorityBean> getPriorities() throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(STATUS).build();
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.get(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<PriorityBean> parse = PriorityParser.parse(objects);
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
}
