package de.micromata.jira.rest.junit;

import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.core.jql.JqlConstants;
import de.micromata.jira.rest.core.util.RestPathConstants;
import org.junit.Before;

import java.net.URI;
import java.net.URISyntaxException;

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

    static final String TEST_SYSTEM_URL = "http://localhost:2990/jira";
    static final String username = "admin";
    static final String password = "admin";

    JiraRestClient jiraRestClient;

    @Before
    public void connect() throws URISyntaxException {
        URI uri = new URI(TEST_SYSTEM_URL);
        jiraRestClient = JiraRestClient.create(uri, username, password);
    }
}
