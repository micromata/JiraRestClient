package de.micromata.jira.rest.junit;

import de.micromata.jira.rest.core.domain.*;
import de.micromata.jira.rest.core.jql.EField;
import de.micromata.jira.rest.core.util.JsonConstants;
import de.micromata.jira.rest.core.util.RestException;
import junit.framework.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 11.08.2014
 */
public class TestIssueClient extends BaseTest {

    private static final String ISSUE_KEY = "DEMO-1";


    @Test
    public void testGetIssueByKey() throws RestException {
        IssueBean issueByKey = jiraRestClient.getIssueClient().getIssueByKey(ISSUE_KEY);
        Assert.assertNotNull(issueByKey);
        Assert.assertEquals(ISSUE_KEY, issueByKey.getKey());
    }


    @Test
    public void testGetIssueKeyWithFields() throws RestException {
        List<String> field = new ArrayList<String>();
        field.add(EField.SUMMARY.getField());
        field.add(EField.DESCRIPTION.getField());
        List<String> expand = new ArrayList<String>();
        expand.add(EField.RENDEREDFIELDS.getField());
        IssueBean issueByKey = jiraRestClient.getIssueClient().getIssueByKey(ISSUE_KEY, field, expand);
        Assert.assertNotNull(issueByKey);
        Assert.assertNotNull(issueByKey.getSummary());
        Assert.assertNotNull(issueByKey.getDescription());
        Assert.assertNotNull(issueByKey.getRenderedFieldsBean());
    }


    @Test
    public void testCreateIssue() throws ParseException, RestException {
        IssueBean issue = new IssueBean();
        issue.setDescription("Test Description");
        issue.setSummary("Test Title");
        issue.setProjectKey("REMOTE");
        issue.setIssueTypeName("Bug");
        issue.setPriorityName(JsonConstants.PRIORITY_CRITICAL);

        String dueDateString = "2015-08-01";
        Date dueDate = sdf.parse(dueDateString);
        issue.setDueDate(dueDate);

//        ComponentBean componentBean1 = new ComponentBean();
//        componentBean1.setName("Backend");
//        issue.getComponents().add(componentBean1);
//        ComponentBean componentBean2 = new ComponentBean();
//        componentBean2.setName("Frontend");
//        issue.getComponents().add(componentBean2);
//
//        VersionBean versionBean1 = new VersionBean();
//        versionBean1.setName("1.1");
//        VersionBean versionBean2 = new VersionBean();
//        versionBean2.setName("1.0");
//        issue.getVersions().add(versionBean1);
//        issue.getVersions().add(versionBean2);
//        issue.getFixVersions().add(versionBean1);
//        issue.getFixVersions().add(versionBean2);

        UserBean userBean = new UserBean();
        userBean.setName("christians");
        issue.setAssignee(userBean);

        issue.getTags().add("foobar");
        issue.getTags().add("inubit");

        TimetrackingBean timetrackingBean = new TimetrackingBean();
        timetrackingBean.setOriginalEstimate("480");
        issue.setTimetrackingBean(timetrackingBean);

        IssueResponse issueResponse = jiraRestClient.getIssueClient().createIssue(issue);
        if (issueResponse != null) {
            String issueKey = issueResponse.getKey();
            if (issueKey != null) {
                System.out.println(issueKey);
            } else {
                System.out.println(issueResponse.getErrorBean());
            }
        }
    }

}
