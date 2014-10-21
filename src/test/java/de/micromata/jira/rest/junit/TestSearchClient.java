package de.micromata.jira.rest.junit;

import de.micromata.jira.rest.core.domain.JqlSearchResultBean;
import de.micromata.jira.rest.core.jql.*;
import de.micromata.jira.rest.core.util.RestException;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 11.08.2014
 */
public class TestSearchClient extends BaseTest{

    @Test
    public void testSearchIssues() throws RestException, IOException {
        JqlSearchBean jsb = new JqlSearchBean();
        JqlBuilder builder = new JqlBuilder();
        String jql = builder.addCondition(EField.PROJECT, EOperator.EQUALS, "DEMO")
                .and().addCondition(EField.STATUS, EOperator.EQUALS, STATUS_OPEN)
                .orderBy(SortOrder.ASC, EField.CREATED);
        jsb.setJql(jql);
        jsb.addField(EField.ISSUE_KEY, EField.STATUS, EField.DUE, EField.SUMMARY, EField.ISSUE_TYPE, EField.PRIORITY, EField.UPDATED, EField.TRANSITIONS);
        jsb.addExpand(EField.TRANSITIONS);
//        jsb.addField(EField.ALL);
//        jsb.addExpand(EField.TRANSITIONS);
        JqlSearchResultBean jqlSearchResultBean = jiraRestClient.getSearchClient().searchIssues(jsb);
        Assert.assertNotNull(jqlSearchResultBean);
        Assert.assertEquals(6, jqlSearchResultBean.getTotal());
        Assert.assertEquals(6, jqlSearchResultBean.getIssueBeans().size());
    }
}
