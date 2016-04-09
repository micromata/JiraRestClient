package de.micromata.jira.rest.core;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.SearchClient;
import de.micromata.jira.rest.core.domain.ComponentBean;
import de.micromata.jira.rest.core.domain.JqlSearchResult;
import de.micromata.jira.rest.core.domain.filter.FilterBean;
import de.micromata.jira.rest.core.jql.JqlSearchBean;
import de.micromata.jira.rest.core.misc.RestParamConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import de.micromata.jira.rest.core.util.HttpMethodFactory;
import de.micromata.jira.rest.core.util.RestException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 01.08.2014
 */
public class SearchClientImpl extends BaseClient implements SearchClient, RestPathConstants, RestParamConstants {


    public SearchClientImpl(JiraRestClient jiraRestClient, ExecutorService executorService) {
        super(jiraRestClient);
        this.executorService = executorService;
    }

    public Future<JqlSearchResult> searchIssues(final JqlSearchBean jsb) throws RestException, IOException {
        Validate.notNull(jsb);
        return executorService.submit(new Callable<JqlSearchResult>() {
            public JqlSearchResult call() throws Exception {

                String json = gson.toJson(jsb);
                URIBuilder uriBuilder = buildPath(SEARCH);
                HttpPost method = HttpMethodFactory.createPostMethod(uriBuilder.build(), json);
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    JsonReader jsonReader = getJsonReader(response);
                    JqlSearchResult jqlSearchResult = gson.fromJson(jsonReader, JqlSearchResult.class);
                    response.close();
                    return jqlSearchResult;
                } else {
                    RestException restException = new RestException(response);
                    method.releaseConnection();
                    response.close();
                    throw restException;
                }
            }
        });

    }


    public Future<FilterBean> createSearchFilter(FilterBean filter) {
        return executorService.submit(new Callable<FilterBean>() {
            @Override
            public FilterBean call() throws Exception {
                URIBuilder uriBuilder = buildPath(FILTER);
                HttpPost method = HttpMethodFactory.createPostMethod(uriBuilder.build(), filter.toString());
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    JsonReader jsonReader = getJsonReader(response);
                    FilterBean filter = gson.fromJson(jsonReader, FilterBean.class);
                    response.close();
                    return filter;
                } else {
                    RestException restException = new RestException(response);
                    method.releaseConnection();
                    response.close();
                    throw restException;
                }
            }
        });
    }


    public Future<List<FilterBean>> getFavoriteFilter() {
        return executorService.submit(new Callable<List<FilterBean>>() {
            @Override
            public List<FilterBean> call() throws Exception {
                URIBuilder uriBuilder = buildPath(FILTER, FAVORITE);
                HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    JsonReader jsonReader = getJsonReader(response);
                    Type listType = new TypeToken<ArrayList<FilterBean>>() {
                    }.getType();
                    List<FilterBean> filters = gson.fromJson(jsonReader, listType);
                    response.close();
                    return filters;
                } else {
                    RestException restException = new RestException(response);
                    method.releaseConnection();
                    response.close();
                    throw restException;
                }
            }
        });
    }


    public Future<FilterBean> getFilterById(String id) {
        return executorService.submit(new Callable<FilterBean>() {
            @Override
            public FilterBean call() throws Exception {
                URIBuilder uriBuilder = buildPath(FILTER, id);
                HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
                CloseableHttpResponse response = client.execute(method, clientContext);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    JsonReader jsonReader = getJsonReader(response);
                    FilterBean filter = gson.fromJson(jsonReader, FilterBean.class);
                    response.close();
                    return filter;
                } else {
                    RestException restException = new RestException(response);
                    method.releaseConnection();
                    response.close();
                    throw restException;
                }
            }
        });
    }
}
