package de.micromata.jira.rest.junit;


import de.micromata.jira.rest.core.domain.AttachmentMetaBean;
import de.micromata.jira.rest.core.domain.IssuetypeBean;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.StatusBean;
import de.micromata.jira.rest.core.domain.field.CreateFieldBean;
import de.micromata.jira.rest.core.domain.field.FieldBean;
import de.micromata.jira.rest.core.util.RestException;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 09.08.2014
 */
public class TestSystemClient extends BaseTest {

    private static final int DEFAULT_NUMBER_OF_ISSUETYPES = 5;
    private static final int DEFAULT_NUMBER_OF_STATES = 5;
    private static final int DEFAULT_NUMBER_OF_PRIORITIES = 5;
    private static final int DEFAULT_NUMBER_OF_FIELDS = 40;
    private static final int DEFAULT_UPLOAD_LIMIT = 10485760;

    @Test
    public void testGetIssueType() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<List<IssuetypeBean>> future = jiraRestClient.getSystemClient().getIssueTypes();
        while (future.isDone() == false) ;
        final List<IssuetypeBean> issuetypeBeans = future.get();
        Assert.assertNotNull(issuetypeBeans);
        Assert.assertFalse(issuetypeBeans.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_ISSUETYPES, issuetypeBeans.size());
    }

    @Test
    public void testGetPriorities() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<List<PriorityBean>> future = jiraRestClient.getSystemClient().getPriorities();
        while (future.isDone() == false) ;
        final List<PriorityBean> priorities = future.get();
        Assert.assertNotNull(priorities);
        Assert.assertFalse(priorities.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_PRIORITIES, priorities.size());
    }

    @Test
    public void testGetStates() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<List<StatusBean>> future = jiraRestClient.getSystemClient().getStates();
        while (future.isDone() == false) ;
        final List<StatusBean> statusBeans = future.get();
        Assert.assertNotNull(statusBeans);
        Assert.assertFalse(statusBeans.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_STATES, statusBeans.size());
    }


    @Test
    public void testGetFields() throws ExecutionException, InterruptedException {
        final Future<List<FieldBean>> future = jiraRestClient.getSystemClient().getAllFields();
        while(future.isDone() == false);
        final List<FieldBean> fieldBeans = future.get();
        Assert.assertNotNull(fieldBeans);
        Assert.assertFalse(fieldBeans.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_FIELDS, fieldBeans.size());
    }

    @Test
    public void testCreateCustomField() throws ExecutionException, InterruptedException {
        CreateFieldBean createFieldBean = new CreateFieldBean();
        createFieldBean.setName("foobar_".concat(new Date().toString()));
        createFieldBean.setDescription("");
        createFieldBean.setType("com.atlassian.jira.plugin.system.customfieldtypes:grouppicker");
        createFieldBean.setSearcherKey("com.atlassian.jira.plugin.system.customfieldtypes:grouppickersearcher");
        final Future<FieldBean> future = jiraRestClient.getSystemClient().createCustomField(createFieldBean);
        while(future.isDone() == false);
        final FieldBean fieldBean = future.get();
        Assert.assertNotNull(fieldBean);
    }

    @Test
    public void testGetCustomFields() throws ExecutionException, InterruptedException {
        final Future<List<FieldBean>> future = jiraRestClient.getSystemClient().getAllCustomFields();
        while(future.isDone() == false);
        final List<FieldBean> fieldBeans = future.get();
        Assert.assertNotNull(fieldBeans);
    }

    @Test
    public void testGetAttachmentMeta() throws ExecutionException, InterruptedException {
        final Future<AttachmentMetaBean> future = jiraRestClient.getSystemClient().getAttachmentMeta();
        while(future.isDone() == false);
        final AttachmentMetaBean attachmentMetaBean = future.get();
        Assert.assertNotNull(attachmentMetaBean);
        Assert.assertEquals(DEFAULT_UPLOAD_LIMIT, attachmentMetaBean.getUploadLimit());
    }


}
