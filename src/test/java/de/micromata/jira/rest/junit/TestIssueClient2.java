package de.micromata.jira.rest.junit;

import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.core.domain.*;
import de.micromata.jira.rest.core.domain.field.FieldBean;
import de.micromata.jira.rest.core.domain.update.FieldOperation;
import de.micromata.jira.rest.core.domain.update.IssueUpdate;
import de.micromata.jira.rest.core.domain.update.Operation;
import de.micromata.jira.rest.core.jql.EField;
import de.micromata.jira.rest.core.misc.JsonConstants;
import de.micromata.jira.rest.core.util.RestException;
import de.micromata.jira.rest.core.util.URIHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 11.08.2014
 */
public class TestIssueClient2 extends BaseTest {
 
    @Test
    public void testGetIssueByKey() throws IOException, RestException, ExecutionException, InterruptedException {
    	
    	System.out.println(jiraRestClient.getIssueClient().toString());
        Future<IssueBean> future = jiraRestClient.getIssueClient().getIssueByKey(ISSUEKEY_TO_SEARCH);
       // Map<String, FieldBean> customfields = JiraRestClient.getCustomfields();
        final IssueBean issueBean = future.get();
        System.out.println(issueBean.toString());
      /*  
        Assert.assertNotNull(issueBean);
        Assert.assertEquals(ISSUEKEY_TO_SEARCH, issueBean.getKey());*/
    }

 
}
