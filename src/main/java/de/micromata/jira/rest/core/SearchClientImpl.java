package de.micromata.jira.rest.core;

import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.client.SearchClient;
import de.micromata.jira.rest.core.domain.JqlSearchResultBean;
import de.micromata.jira.rest.core.jql.JqlSearchBean;
import de.micromata.jira.rest.core.parser.JqlSearchParser;
import de.micromata.jira.rest.core.util.GsonParserUtil;
import de.micromata.jira.rest.core.util.RestException;
import de.micromata.jira.rest.core.util.RestURIBuilder;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 01.08.2014
 */
public class SearchClientImpl implements SearchClient {


    private JiraRestClient jiraRestClient = null;

    private SearchClientImpl() {
    }

    public SearchClientImpl(JiraRestClient jiraRestClient) {
        this.jiraRestClient = jiraRestClient;
    }

    @Override
    public JqlSearchResultBean searchIssuesForProject(JqlSearchBean jsb) throws RestException {
        Client client = jiraRestClient.getClient();
        URI baseUri = jiraRestClient.getBaseUri();
        String json = GsonParserUtil.parseObjectToJson(jsb);
        URI uri = RestURIBuilder.buildSearchURI(baseUri);
        WebResource webResource = client.resource(uri);
        ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).entity(json).post(ClientResponse.class);
        if (clientResponse.getStatus() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = clientResponse.getEntityInputStream();
            JsonObject jsonObject = GsonParserUtil.parseJsonObject(inputStream);
            JqlSearchResultBean jqlSearchResultBean = JqlSearchParser.parse(jsonObject);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientResponse.close();
            return jqlSearchResultBean;
        } else {
            throw new RestException(clientResponse);
        }
    }
}
