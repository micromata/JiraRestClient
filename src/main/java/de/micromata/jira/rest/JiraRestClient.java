package de.micromata.jira.rest;

import de.micromata.jira.rest.client.*;
import de.micromata.jira.rest.core.*;
import de.micromata.jira.rest.core.util.HttpMethodFactory;
import de.micromata.jira.rest.core.util.RestParamConstants;
import de.micromata.jira.rest.core.util.RestPathConstants;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.lang3.StringUtils;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 22.08.2014
 */
public class JiraRestClient implements RestParamConstants, RestPathConstants {


    private HttpClient client;
    /**
     * The base URI.
     */
    private URI baseUri;

    private String username = StringUtils.EMPTY;


    public JiraRestClient() {
    }


    public static JiraRestClient create(URI uri, String username, String password) throws IOException {
        JiraRestClient retval = new JiraRestClient();
        retval.connect(uri, username, password);
        return retval;
    }


    /**
     * Builds and configures a new client connection to JIRA.
     *
     * @param uri      = the login mask URI where JIRA is running
     * @param username = login name
     * @param password = login password
     * @throws de.micromata.jira.rest.core.util.RestException
     */
    public int connect(URI uri, String username, String password) throws IOException {
        this.username = username;
        // Client Parameters
        HttpClientParams params = new HttpClientParams();
        params.setAuthenticationPreemptive(true);
        params.setCookiePolicy(CookiePolicy.RFC_2109);
        client = new HttpClient(params);
        // HostConfiguration
        HostConfiguration hostConfiguration = new HostConfiguration();
        hostConfiguration.setHost(uri.getHost(), uri.getPort());
        client.setHostConfiguration(hostConfiguration);
        //
        AuthScope myhost = new AuthScope(uri.getHost(), uri.getPort(), AuthScope.ANY_REALM);
        Credentials defaultcreds = new UsernamePasswordCredentials(username, password);
        client.getState().setCredentials(myhost, defaultcreds);
        this.baseUri = UriBuilder.fromUri(uri).path(RestPathConstants.BASE_REST_PATH).build();
        UriBuilder path = UriBuilder.fromUri(baseUri).path(USER);
        path.queryParam(USERNAME, username);
        URI uri1 = path.build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri1);
        client.executeMethod(method);
        String responseBodyAsString = method.getResponseBodyAsString();
        int statusCode = method.getStatusCode();
        return statusCode;
    }


    public IssueClient getIssueClient() {
        return new IssueClientImpl(this);
    }

    public ProjectClient getProjectClient() {
        return new ProjectClientImpl(this);
    }

    public SearchClient getSearchClient() {
        return new SearchClientImpl(this);
    }

    public SystemClient getSystemClient() {
        return new SystemClientImpl(this);
    }

    public UserClient getUserClient() {
        return new UserClientImpl(this);
    }


    public HttpClient getClient() {
        return client;
    }

    /**
     * Gets the base URI.
     *
     * @return the base URI
     */
    public URI getBaseUri() {
        return baseUri;
    }

    public String getUsername() {
        return username;
    }
}
