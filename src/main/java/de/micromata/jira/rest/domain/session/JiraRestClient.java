package de.micromata.jira.rest.domain.session;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.Base64;
import de.micromata.jira.rest.util.RestConstants;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 01.03.13
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
public class JiraRestClient {

    private Client client;

    private String auth;

    private URI baseUri;

    public JiraRestClient(String uri, String username, String password) {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
                Boolean.TRUE);
        client = Client.create(clientConfig);
        String authString = username + ":" + password;
        auth = new String(Base64.encode(authString));
        baseUri = UriBuilder.fromUri(uri).path(RestConstants.BASE_REST_PATH).build();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public URI getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(URI baseUri) {
        this.baseUri = baseUri;
    }
}
