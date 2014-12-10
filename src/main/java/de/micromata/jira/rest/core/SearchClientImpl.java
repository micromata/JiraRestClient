package de.micromata.jira.rest.core;

import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.SearchClient;
import de.micromata.jira.rest.core.domain.JqlSearchResult;
import de.micromata.jira.rest.core.jql.JqlSearchBean;
import de.micromata.jira.rest.core.misc.RestParamConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import de.micromata.jira.rest.core.util.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 01.08.2014
 */
public class SearchClientImpl extends BaseClient implements SearchClient, RestPathConstants, RestParamConstants {

    private JiraRestClient jiraRestClient = null;

    private SearchClientImpl() {
    }

    public SearchClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
    }

    @Override
    public Future<JqlSearchResult> searchIssues(final JqlSearchBean jsb) throws RestException, IOException {
        return executorService.submit(new Callable<JqlSearchResult>() {
            @Override
            public JqlSearchResult call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                URI baseUri = jiraRestClient.getBaseUri();
                String json = GsonParserUtil.parseObjectToJson(jsb);
                URI uri = UriBuilder.fromUri(baseUri).path(SEARCH).build();
                PostMethod method = HttpMethodFactory.createPostMethod(uri, json);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    JqlSearchResult jqlSearchResult = gson.fromJson(jsonReader, JqlSearchResult.class);
                    method.releaseConnection();
                    return jqlSearchResult;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });

    }
}
