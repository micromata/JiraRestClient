package de.micromata.jira.rest.core;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.SystemClient;
import de.micromata.jira.rest.core.domain.AttachmentMetaBean;
import de.micromata.jira.rest.core.domain.IssuetypeBean;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.StatusBean;
import de.micromata.jira.rest.core.domain.field.CreateFieldBean;
import de.micromata.jira.rest.core.domain.field.FieldBean;
import de.micromata.jira.rest.core.domain.system.ConfigurationBean;
import de.micromata.jira.rest.core.misc.RestParamConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import de.micromata.jira.rest.core.util.HttpMethodFactory;
import de.micromata.jira.rest.core.util.RestException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 31.07.2014
 */
public class SystemClientImpl extends BaseClient implements SystemClient, RestParamConstants, RestPathConstants {


    public SystemClientImpl(JiraRestClient jiraRestClient, ExecutorService executorService) {
        super(jiraRestClient);
        this.executorService = executorService;
    }


    @Override
    public Future<ConfigurationBean> getConfiguration() throws RestException, IOException {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(CONFIGURATION);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                ConfigurationBean configuration = gson.fromJson(jsonReader, ConfigurationBean.class);
                method.releaseConnection();
                return configuration;
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }

    public Future<List<IssuetypeBean>> getIssueTypes() throws RestException, IOException {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(ISSUETPYES);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                Type listType = new TypeToken<ArrayList<IssuetypeBean>>() {
                }.getType();
                List<IssuetypeBean> issuetypes = gson.fromJson(jsonReader, listType);
                method.releaseConnection();
                return issuetypes;
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });

    }


    public Future<List<StatusBean>> getStates() throws RestException, IOException {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(STATUS);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                Type listType = new TypeToken<ArrayList<StatusBean>>() {
                }.getType();
                List<StatusBean> states = gson.fromJson(jsonReader, listType);
                method.releaseConnection();
                return states;
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });

    }


    public Future<List<PriorityBean>> getPriorities() throws RestException, IOException {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PRIORITY);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                Type listType = new TypeToken<ArrayList<PriorityBean>>() {
                }.getType();
                List<PriorityBean> priorities = gson.fromJson(jsonReader, listType);
                method.releaseConnection();
                return priorities;
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }


    public Future<List<FieldBean>> getAllFields() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(FIELD);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                Type listType = new TypeToken<ArrayList<FieldBean>>() {
                }.getType();
                List<FieldBean> fields = gson.fromJson(jsonReader, listType);
                method.releaseConnection();
                return fields;
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }


    public Future<List<FieldBean>> getAllCustomFields() {
        return executorService.submit(() -> {
            List<FieldBean> retval = new ArrayList<>();
            Future<List<FieldBean>> allFields = getAllFields();
            List<FieldBean> fieldBeen = allFields.get();
            for (FieldBean fieldBean : fieldBeen) {
                if (fieldBean.getCustom() == true) {
                    retval.add(fieldBean);
                }
            }
            return retval;
        });
    }


    public Future<FieldBean> getCustomFieldById(final String id) {
        return executorService.submit(() -> {
            Future<List<FieldBean>> allFields = getAllFields();
            List<FieldBean> fieldBeen = allFields.get();
            for (FieldBean fieldBean : fieldBeen) {
                if (fieldBean.getCustom() == false) {
                    continue;
                }
                if (fieldBean.getId().contains(id) == true) {
                    return fieldBean;
                }
            }
            return null;
        });
    }


    public Future<AttachmentMetaBean> getAttachmentMeta() {
        return null;
    }

    @Override
    public Future<FieldBean> createCustomField(CreateFieldBean customField) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(FIELD);
            HttpPost method = HttpMethodFactory.createPostMethod(uriBuilder.build(), customField.toString());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_CREATED) {
                JsonReader jsonReader = getJsonReader(response);
                FieldBean fieldBean = gson.fromJson(jsonReader, FieldBean.class);
                return fieldBean;
            } else {
                RestException restException = new RestException(response);
                method.releaseConnection();
                response.close();
                throw restException;
            }
        });
    }
}
