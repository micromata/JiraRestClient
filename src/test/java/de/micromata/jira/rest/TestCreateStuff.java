package de.micromata.jira.rest;

import de.micromata.jira.rest.domain.IssueBean;
import de.micromata.jira.rest.domain.IssueResponse;
import de.micromata.jira.rest.util.JsonConstants;
import de.micromata.jira.rest.util.RestException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Christian on 02.07.2014.
 */
public class TestCreateStuff extends BaseTest {


    public static void main(String[] args) throws URISyntaxException, RestException, IOException {
        new TestCreateStuff().run();
    }

    private void run() throws URISyntaxException, RestException {
        connect();
        testCreateIssue();
    }

    public void testCreateIssue() throws RestException {
        IssueBean issue = new IssueBean();
        issue.setDescription("Test Description");
        issue.setSummary("Test Title");
        issue.setProjectKey("DEMO");
        issue.setComponentName("TEST");
        issue.setPriorityName(JsonConstants.PRIORITY_CRITICAL);
        IssueResponse issueResponse = restWrapper.createIssue(issue, jiraRestClient);
        if(issueResponse != null){
            String issueKey = issueResponse.getKey();
            if(issueKey != null){
                System.out.println(issueKey);
            }else{
                System.out.println(issueResponse.getErrorBean());
            }
        }
    }

}
