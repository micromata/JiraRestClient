package de.micromata.jira.rest.junit;

import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.core.jql.JqlConstants;
import de.micromata.jira.rest.core.util.RestPathConstants;
import org.apache.commons.httpclient.ProxyHost;
import org.junit.Before;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

/**
 * Junit-Test for JiraRestClient.
 * You need a running Jira-Instance with the TEST_SYSTEM_URL.
 * Best use is the atlassian-plugin-sdk
 *
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 09.08.2014
 */
public class BaseTest implements JqlConstants, RestPathConstants {

    static final String TEST_SYSTEM_URL = "http://localhost:2990";
    static final String USERNAME = "admin";
    static final String PASSWORD = "admin";
    static final String USERNAME_TO_SEARCH = "admin";
    static final String ISSUEKEY_TO_SEARCH = "DEMO-1";
    static final String PROJECT_TO_SEARCH = "DEMO";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    JiraRestClient jiraRestClient;

    @Before
    public void connect() throws URISyntaxException, IOException {

        ProxyHost proxy = new ProxyHost("proxy", 3128);
        URI uri = new URI(TEST_SYSTEM_URL);
        jiraRestClient = JiraRestClient.create(uri, USERNAME, PASSWORD, proxy);
    }
}
