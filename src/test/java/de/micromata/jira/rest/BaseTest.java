package de.micromata.jira.rest;

import de.micromata.jira.rest.core.jql.JqlConstants;
import de.micromata.jira.rest.core.util.RestConstants;

import java.net.URISyntaxException;

/**
 * Created by Christian on 02.07.2014.
 */
public class BaseTest implements JqlConstants, RestConstants {
    static final String TEST_SYSTEM_URL = "http://localhost:2990/jira";
    static final String username = "admin";
    static final String password = "admin";


    JiraRestClient jiraRestClient;
    RestWrapper restWrapper;

    void connect() throws URISyntaxException {
//        URI uri = new URI(TEST_SYSTEM_URL);
//        restWrapper = new RestWrapperImpl();
//        jiraRestClient = new JiraRestClient();
//        int status = jiraRestClient.connect(uri, username, password);
//        if (status != HttpURLConnection.HTTP_OK) {
//            System.out.println("FehlerStatus: " + status);
//        }
    }

}
