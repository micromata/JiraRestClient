package de.micromata.jira.rest.core;

import com.google.gson.JsonObject;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.SystemClient;
import de.micromata.jira.rest.core.domain.IssueTypeBean;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.StatusBean;
import de.micromata.jira.rest.core.parser.IssueTypeParser;
import de.micromata.jira.rest.core.parser.PriorityParser;
import de.micromata.jira.rest.core.parser.StatusParser;
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
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 31.07.2014
 */
public class SystemClientImpl implements SystemClient, RestParamConstants, RestPathConstants {


    private JiraRestClient jiraRestClient = null;

    private HttpClient client = null;

    private SystemClientImpl() {
    }

    public SystemClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
        this.client = jiraRestClient.getClient();
    }

    @Override
    public List<IssueTypeBean> getIssueTypes() throws RestException, IOException {
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(ISSUETPYES).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<IssueTypeBean> parse = IssueTypeParser.parse(objects);
            method.releaseConnection();
            Collections.sort(parse);
            return parse;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public List<StatusBean> getStates() throws RestException, IOException {
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(STATUS).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<StatusBean> parse = StatusParser.parse(objects);
            method.releaseConnection();
            Collections.sort(parse);
            return parse;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }

    @Override
    public List<PriorityBean> getPriorities() throws RestException, IOException {
        URI baseUri = jiraRestClient.getBaseUri();
        URI uri = UriBuilder.fromUri(baseUri).path(STATUS).build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            List<JsonObject> objects = GsonParserUtil.parseJsonObjects(inputStream);
            List<PriorityBean> parse = PriorityParser.parse(objects);
            method.releaseConnection();
            Collections.sort(parse);
            return parse;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }
}
