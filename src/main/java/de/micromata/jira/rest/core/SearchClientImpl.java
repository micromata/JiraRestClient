package de.micromata.jira.rest.core;

import com.google.gson.JsonObject;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.SearchClient;
import de.micromata.jira.rest.core.domain.JqlSearchResultBean;
import de.micromata.jira.rest.core.jql.JqlSearchBean;
import de.micromata.jira.rest.core.parser.JqlSearchParser;
import de.micromata.jira.rest.core.util.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 01.08.2014
 */
public class SearchClientImpl implements SearchClient, RestPathConstants, RestParamConstants {


    private JiraRestClient jiraRestClient = null;

    private SearchClientImpl() {
    }

    public SearchClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
    }

    @Override
    public JqlSearchResultBean searchIssues(JqlSearchBean jsb) throws RestException, IOException {
        HttpClient client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        String json = GsonParserUtil.parseObjectToJson(jsb);
        URI uri = UriBuilder.fromUri(baseUri).path(SEARCH).build();
        PostMethod method = HttpMethodFactory.createPostMethod(uri, json);
        int status = client.executeMethod(method);
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = method.getResponseBodyAsStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            JqlSearchResultBean jqlSearchResultBean = JqlSearchParser.parse(jsonObject);
            method.releaseConnection();
            return jqlSearchResultBean;
        } else {
            method.releaseConnection();
            throw new RestException(method);
        }
    }
}
