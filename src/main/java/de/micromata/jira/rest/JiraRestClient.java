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
import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 01.03.13
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
public class JiraRestClient {

    private ApacheHttpClient client;

    private URI baseUri;

    private String username = StringUtils.EMPTY;

    public JiraRestClient(String uri, String username, String password) {
        this.username = username;
    	String authString = username + ":" + password;
    	String auth = new String(Base64.encode(authString));

    	ApacheHttpClientConfig clientConfig = new DefaultApacheHttpClientConfig();
        clientConfig.getProperties().put(ApacheHttpClientConfig.PROPERTY_HANDLE_COOKIES, Boolean.TRUE);
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        this.client = ApacheHttpClient.create(clientConfig);
        
        this.baseUri = UriBuilder.fromUri(uri).path(RestConstants.BASE_REST_PATH).build();
        this.client.resource(baseUri).header(RestConstants.AUTHORIZATION, RestConstants.BASIC + auth).
        	type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }

    public ApacheHttpClient getClient() {
        return client;
    }

    public URI getBaseUri() {
        return baseUri;
    }

    public String getUsername() {
        return username;
    }
}
