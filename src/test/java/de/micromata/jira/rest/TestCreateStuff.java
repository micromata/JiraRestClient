package de.micromata.jira.rest;

import de.micromata.jira.rest.domain.*;
import de.micromata.jira.rest.util.JsonConstants;
import de.micromata.jira.rest.util.RestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Christian on 02.07.2014.
 */
public class TestCreateStuff extends BaseTest {


    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        try {
            new TestCreateStuff().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run() throws URISyntaxException, RestException, ParseException {
        connect();
        testCreateIssue();
    }

    public void testCreateIssue() throws RestException, ParseException {
        IssueBean issue = new IssueBean();
        issue.setDescription("Test Description");
        issue.setSummary("Test Title");
        issue.setProjectKey("REMOTE");
        issue.setIssueTypeName("Bug");
        issue.setPriorityName(JsonConstants.PRIORITY_CRITICAL);

        String dueDateString = "2015-08-01";
        Date dueDate = sdf.parse(dueDateString);
        issue.setDueDate(dueDate);

        ComponentBean componentBean1 = new ComponentBean();
        componentBean1.setName("Backend");
        issue.getComponents().add(componentBean1);
        ComponentBean componentBean2 = new ComponentBean();
        componentBean2.setName("Frontend");
        issue.getComponents().add(componentBean2);

        VersionBean versionBean1 =new VersionBean();
        versionBean1.setName("1.1");
        VersionBean versionBean2 =new VersionBean();
        versionBean2.setName("1.0");
        issue.getVersions().add(versionBean1);
        issue.getVersions().add(versionBean2);
        issue.getFixVersions().add(versionBean1);
        issue.getFixVersions().add(versionBean2);

        UserBean userBean = new UserBean();
        userBean.setName("christians");
        issue.setAssignee(userBean);

        issue.getTags().add("foobar");
        issue.getTags().add("inubit");

        TimetrackingBean timetrackingBean = new TimetrackingBean();
        timetrackingBean.setOriginalEstimateSeconds(480l);
        issue.setTimetrackingBean(timetrackingBean);

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
