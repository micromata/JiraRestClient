package de.micromata.jira.rest;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.client.apache.ApacheHttpClient;
import com.sun.jersey.client.apache.config.ApacheHttpClientConfig;
import com.sun.jersey.client.apache.config.DefaultApacheHttpClientConfig;
import com.sun.jersey.core.util.Base64;

import de.micromata.jira.rest.util.RestConstants;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 01.03.13
 * Time: 17:22
 * 
 * <p>Contains informations about the client which is connecting to JIRA over REST.</p>
 */
public class JiraRestClient {

    /** The Apache HTTP client. */
    private ApacheHttpClient client;

    /** The base URI. */
    private URI baseUri;

    /**
     * Builds and configures a new client connection to JIRA. 
     *
     * @param uri = the login mask URI where JIRA is running
     * @param username = login name
     * @param password = login password
     */
    public JiraRestClient(String uri, String username, String password) {
    	String authString = username + ":" + password;
    	String auth = new String(Base64.encode(authString));

    	//Apache HTTP client setup 
    	ApacheHttpClientConfig clientConfig = new DefaultApacheHttpClientConfig();
        clientConfig.getProperties().put(ApacheHttpClientConfig.PROPERTY_HANDLE_COOKIES, Boolean.TRUE);
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        this.client = ApacheHttpClient.create(clientConfig);
        
        this.baseUri = UriBuilder.fromUri(uri).path(RestConstants.BASE_REST_PATH).build();
        this.client.resource(baseUri).header(RestConstants.AUTHORIZATION, RestConstants.BASIC + auth).
        	type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }

    /**
     * Gets the Apache HTTP client.
     *
     * @return the client
     */
    public ApacheHttpClient getClient() {
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

}
