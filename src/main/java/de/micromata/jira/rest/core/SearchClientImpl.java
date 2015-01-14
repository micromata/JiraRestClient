package de.micromata.jira.rest.core;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.SearchClient;
import de.micromata.jira.rest.core.domain.JqlSearchResult;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.filter.FilterBean;
import de.micromata.jira.rest.core.jql.JqlSearchBean;
import de.micromata.jira.rest.core.misc.RestParamConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import de.micromata.jira.rest.core.util.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.logging.Filter;

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
    public Future<JqlSearchResult> searchIssues(final JqlSearchBean jsb){
        return executorService.submit(new Callable<JqlSearchResult>() {
            @Override
            public JqlSearchResult call() throws Exception {
                HttpClient client = jiraRestClient.getClient();
                URI baseUri = jiraRestClient.getBaseUri();
                String json = gson.toJson(jsb);
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

    @Override
    public Future<FilterBean> createSearchFilter(final FilterBean filter) {
        return executorService.submit(new Callable<FilterBean>() {
            @Override
            public FilterBean call() throws Exception {
                final HttpClient client = jiraRestClient.getClient();
                final URI baseUri = jiraRestClient.getBaseUri();
                final URI uri = UriBuilder.fromUri(baseUri).path(FILTER).build();
                final String json = gson.toJson(filter);
                final PostMethod method = HttpMethodFactory.createPostMethod(uri, json);
                int status = client.executeMethod(method);
                if(status == HttpURLConnection.HTTP_OK){
                    final InputStream inputStream = method.getResponseBodyAsStream();
                    final JsonReader jsonReader = toJsonReader(inputStream);
                    final FilterBean filterBean = gson.fromJson(jsonReader, FilterBean.class);
                    method.releaseConnection();
                    return filterBean;
                }else{
                    final RestException restException = new RestException(method);
                    method.releaseConnection();
                    throw restException;
                }
            }
        });
    }

    @Override
    public Future<List<FilterBean>> getFavoriteFilter() {
        return executorService.submit(new Callable<List<FilterBean>>() {
            @Override
            public List<FilterBean> call() throws Exception {
                final HttpClient client = jiraRestClient.getClient();
                final URI baseUri = jiraRestClient.getBaseUri();
                final URI uri = UriBuilder.fromUri(baseUri).path(FILTER).path(FAVORITE).build();
                final GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if(status == HttpURLConnection.HTTP_OK){
                    final InputStream inputStream = method.getResponseBodyAsStream();
                    final JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<FilterBean>>(){}.getType();
                    final List<FilterBean> filterBeans = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    return filterBeans;
                }else{
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }

    @Override
    public Future<FilterBean> getFilterById(String id) {
        throw new NotImplementedException();
    }
}
