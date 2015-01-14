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
import de.micromata.jira.rest.core.misc.RestParamConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import de.micromata.jira.rest.core.util.HttpMethodFactory;
import de.micromata.jira.rest.core.util.RestException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

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

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 31.07.2014
 */
public class SystemClientImpl extends BaseClient implements SystemClient, RestParamConstants, RestPathConstants {


    private JiraRestClient jiraRestClient = null;

    private HttpClient client = null;


    public SystemClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
        this.client = jiraRestClient.getClient();
    }

    @Override
    public Future<List<IssuetypeBean>> getIssueTypes() throws RestException, IOException {
        return executorService.submit(new Callable<List<IssuetypeBean>>() {
            @Override
            public List<IssuetypeBean> call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(ISSUETPYES).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<IssuetypeBean>>(){}.getType();
                    List<IssuetypeBean> issuetypes = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    return issuetypes;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });

    }

    @Override
    public Future<List<StatusBean>> getStates() throws RestException, IOException {
        return executorService.submit(new Callable<List<StatusBean>>() {
            @Override
            public List<StatusBean> call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(STATUS).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<StatusBean>>(){}.getType();
                    List<StatusBean> states = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    return states;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });

    }

    @Override
    public Future<List<PriorityBean>> getPriorities() throws RestException, IOException {
        return executorService.submit(new Callable<List<PriorityBean>>() {
            @Override
            public List<PriorityBean> call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(PRIORITY).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<PriorityBean>>(){}.getType();
                    List<PriorityBean> priorities = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    return priorities;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }

    @Override
    public Future<List<FieldBean>> getAllFields() {
        return executorService.submit(new Callable<List<FieldBean>>() {
            @Override
            public List<FieldBean> call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(FIELD).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<FieldBean>>(){}.getType();
                    List<FieldBean> fieldBeans = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    return fieldBeans;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });


    }

    @Override
    public Future<FieldBean> createCustomField(final CreateFieldBean customfield) {
        return executorService.submit(new Callable<FieldBean>() {
            @Override
            public FieldBean call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(FIELD).build();
                final String json = gson.toJson(customfield);
                final PostMethod method = HttpMethodFactory.createPostMethod(uri, json);
                final int status = client.executeMethod(method);
                if(status == HttpURLConnection.HTTP_CREATED){
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    FieldBean fieldBean = gson.fromJson(jsonReader, FieldBean.class);
                    method.releaseConnection();
                    return fieldBean;
                }else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }

    @Override
    public Future<List<FieldBean>> getAllCustomFields() {
        return executorService.submit(new Callable<List<FieldBean>>() {
            @Override
            public List<FieldBean> call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(FIELD).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<FieldBean>>(){}.getType();
                    List<FieldBean> fieldBeans = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    List<FieldBean> customFields = new ArrayList<FieldBean>();
                    for (FieldBean fieldBean : fieldBeans) {
                        if(fieldBean.getCustom()){
                            customFields.add(fieldBean);
                        }
                    }

                    return customFields;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }

    @Override
    public Future<FieldBean> getCustomFieldById(final String id) {
        return executorService.submit(new Callable<FieldBean>() {
            @Override
            public FieldBean call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(FIELD).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    Type listType = new TypeToken<ArrayList<FieldBean>>(){}.getType();
                    List<FieldBean> fieldBeans = gson.fromJson(jsonReader, listType);
                    method.releaseConnection();
                    for (FieldBean fieldBean : fieldBeans) {
                        if(fieldBean.getId().equals(id) && fieldBean.getCustom()){
                            return fieldBean;
                        }
                    }
                    return null;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }

    @Override
    public Future<AttachmentMetaBean> getAttachmentMeta() {
        return executorService.submit(new Callable<AttachmentMetaBean>() {
            @Override
            public AttachmentMetaBean call() throws Exception {
                URI baseUri = jiraRestClient.getBaseUri();
                URI uri = UriBuilder.fromUri(baseUri).path(ATTACHMENT).path(META).build();
                GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri);
                int status = client.executeMethod(method);
                if (status == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = method.getResponseBodyAsStream();
                    JsonReader jsonReader = toJsonReader(inputStream);
                    AttachmentMetaBean attachmentMetaBean = gson.fromJson(jsonReader, AttachmentMetaBean.class);
                    method.releaseConnection();
                    return attachmentMetaBean;
                } else {
                    method.releaseConnection();
                    throw new RestException(method);
                }
            }
        });
    }
}
