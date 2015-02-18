package de.micromata.jira.rest;

import de.micromata.jira.rest.client.*;
import de.micromata.jira.rest.core.*;
import de.micromata.jira.rest.core.util.HttpMethodFactory;
import de.micromata.jira.rest.core.misc.RestParamConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import de.micromata.jira.rest.http.EasySSLProtocolSocketFactory;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 22.08.2014
 */
public class JiraRestClient implements RestParamConstants, RestPathConstants {


    private static final String HTTP = "http";
    private static final String HTTPS = "https";

    private URI baseUri;
    private String username = StringUtils.EMPTY;
    private HttpClient client;
    private ProxyHost proxy;
    private HttpConnectionManager connectionManager;


    public JiraRestClient() {
    }


    public static JiraRestClient create(URI uri, String username, String password) throws IOException {
        JiraRestClient retval = new JiraRestClient();
        retval.connect(uri, username, password, null);
        return retval;
    }

    public static JiraRestClient create(URI uri, String username, String password, ProxyHost proxyHost) throws IOException {
        JiraRestClient retval = new JiraRestClient();
        retval.connect(uri, username, password, proxyHost);
        return retval;
    }

    public int connect(URI uri, String username, String password) throws IOException {
        return connect(uri, username, password, null);
    }

    /**
     * Builds and configures a new client connection to JIRA.
     *
     * @param uri      = the login mask URI where JIRA is running
     * @param username = login name
     * @param password = login password
     * @return 200 succees, 401 for wrong credentials and 403 for captcha is needed, you have to login at the jira website
     * @throws de.micromata.jira.rest.core.util.RestException
     */
    public int connect(URI uri, String username, String password, ProxyHost proxyHost) throws IOException {
        this.username = username;
        HttpClientParams params = new HttpClientParams();
        params.setAuthenticationPreemptive(true);
        params.setCookiePolicy(CookiePolicy.RFC_2109);
        HostConfiguration hostConfiguration = new HostConfiguration();
        String protocol = uri.toURL().getProtocol();
        if (HTTP.equals(protocol)) {
            hostConfiguration.setHost(uri.getHost(), uri.getPort());
        }
        if (HTTPS.equals(protocol)) {
            int port = getPort(uri.toURL());
            ProtocolSocketFactory psf = new EasySSLProtocolSocketFactory();
            Protocol easyhttps = new Protocol(protocol, psf, port);
            hostConfiguration.setHost(uri.getHost(), port, easyhttps);
        }
        connectionManager = createHttpConnectionManager(hostConfiguration);
        client = new HttpClient(params, connectionManager);
        client.setHostConfiguration(hostConfiguration);
        AuthScope authScope = new AuthScope(uri.getHost(), uri.getPort(), AuthScope.ANY_REALM);
        Credentials defaultcreds = new UsernamePasswordCredentials(username, password);
        client.getState().setCredentials(authScope, defaultcreds);
        if (proxyHost != null) {
            this.proxy = proxyHost;
            hostConfiguration.setProxyHost(proxyHost);
            client.getState().setProxyCredentials(AuthScope.ANY, defaultcreds);
        }
        this.baseUri = UriBuilder.fromUri(uri).path(RestPathConstants.BASE_REST_PATH).build();
        UriBuilder path = UriBuilder.fromUri(baseUri).path(USER);
        path.queryParam(USERNAME, username);
        URI uri1 = path.build();
        GetMethod method = HttpMethodFactory.createGetMtGetMethod(uri1);
        client.executeMethod(method);
        int statusCode = method.getStatusCode();
        method.releaseConnection();
        return statusCode;
    }


    /**
     * Extract port from URL
     *
     * @param endpointUrl
     * @return
     */
    private int getPort(URL endpointUrl) {
        int port = (endpointUrl.getPort() != -1 ? endpointUrl.getPort() : endpointUrl.getDefaultPort());
        if (port != -1) {
            return port;
        }
        if (HTTPS.equals(endpointUrl.getProtocol())) {
            return 443;
        }
        return 80;
    }


    private HttpConnectionManager createHttpConnectionManager(HostConfiguration hostConfiguration) {
        HttpConnectionManager retval = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = retval.getParams();
        params.setDefaultMaxConnectionsPerHost(1000);
        params.setMaxConnectionsPerHost(hostConfiguration, 1000);
        params.setMaxTotalConnections(1000);
        return retval;
    }

    public void closeIdleConnections() {
        connectionManager.closeIdleConnections(30000l);
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

    public ProxyHost getProxy() {
        return proxy;
    }
}
