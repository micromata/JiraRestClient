package de.micromata.jira.rest.junit;


import de.micromata.jira.rest.core.domain.AttachmentMetaBean;
import de.micromata.jira.rest.core.domain.IssuetypeBean;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.StatusBean;
import de.micromata.jira.rest.core.domain.customFields.CustomFieldType;
import de.micromata.jira.rest.core.domain.field.CreateFieldBean;
import de.micromata.jira.rest.core.domain.field.FieldBean;
import de.micromata.jira.rest.core.domain.system.ConfigurationBean;
import de.micromata.jira.rest.core.util.RestException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 09.08.2014
 */
public class TestSystemClient extends BaseTest {

    private static final int DEFAULT_NUMBER_OF_ISSUETYPES = 6;
    private static final int DEFAULT_NUMBER_OF_STATES = 5;
    private static final int DEFAULT_NUMBER_OF_PRIORITIES = 5;
    private static final int DEFAULT_NUMBER_OF_FIELDS = 40;
    private static final int DEFAULT_UPLOAD_LIMIT = 10485760;
    private static final int DEFAULT_WORKING_HOURS_PER_DAY = 8;

    @Test
    public void testGetConfiguration() throws IOException, RestException, ExecutionException, InterruptedException {
        Future<ConfigurationBean> future = jiraRestClient.getSystemClient().getConfiguration();
        ConfigurationBean configurationBean = future.get();
        Assert.assertNotNull(configurationBean);
        Assert.assertNotNull(configurationBean.getTimeTrackingConfiguration());
        Assert.assertEquals(DEFAULT_WORKING_HOURS_PER_DAY, configurationBean.getTimeTrackingConfiguration().getWorkingHoursPerDay().intValue());
    }

    @Test
    public void testGetIssueType() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<List<IssuetypeBean>> future = jiraRestClient.getSystemClient().getIssueTypes();
        final List<IssuetypeBean> issuetypeBeans = future.get();
        Assert.assertNotNull(issuetypeBeans);
        Assert.assertFalse(issuetypeBeans.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_ISSUETYPES, issuetypeBeans.size());
    }

    @Test
    public void testGetPriorities() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<List<PriorityBean>> future = jiraRestClient.getSystemClient().getPriorities();
        final List<PriorityBean> priorities = future.get();
        Assert.assertNotNull(priorities);
        Assert.assertFalse(priorities.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_PRIORITIES, priorities.size());
    }

    @Test
    public void testGetStates() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<List<StatusBean>> future = jiraRestClient.getSystemClient().getStates();
        final List<StatusBean> statusBeans = future.get();
        Assert.assertNotNull(statusBeans);
        Assert.assertFalse(statusBeans.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_STATES, statusBeans.size());
    }


    @Test
    public void testGetFields() throws ExecutionException, InterruptedException {
        final Future<List<FieldBean>> future = jiraRestClient.getSystemClient().getAllFields();
        final List<FieldBean> fieldBeans = future.get();
        Assert.assertNotNull(fieldBeans);
        Assert.assertFalse(fieldBeans.isEmpty());
        int numberOfFields = 0;
        for (FieldBean fieldBean : fieldBeans) {
            if(fieldBean.getCustom() == false){
                numberOfFields = numberOfFields + 1;
            }
        }
        Assert.assertEquals(DEFAULT_NUMBER_OF_FIELDS, numberOfFields);
    }


    @Test
    public void testGetCustomFields() throws ExecutionException, InterruptedException {
        final Future<List<FieldBean>> future = jiraRestClient.getSystemClient().getAllCustomFields();
        final List<FieldBean> fieldBeans = future.get();
        Assert.assertNotNull(fieldBeans);
    }

    @Test
    public void testGetCustomFieldById() throws ExecutionException, InterruptedException {
        Future<FieldBean> future = jiraRestClient.getSystemClient().getCustomFieldById("10000");
        FieldBean fieldBean = future.get();
        Assert.assertNotNull(fieldBean);
    }

    @Test
    public void testCreateCustomField() throws ExecutionException, InterruptedException {
        CreateFieldBean createFieldBean = new CreateFieldBean();
        createFieldBean.setName("New Custom Field");
        createFieldBean.setDescription("Custom field for picking groups");
        createFieldBean.setType(CustomFieldType.GROUP.getJiraName());
        Future<FieldBean> customField = jiraRestClient.getSystemClient().createCustomField(createFieldBean);
        FieldBean fieldBean = customField.get();
        Assert.assertNotNull(fieldBean);
        Assert.assertEquals(createFieldBean.getName(), fieldBean.getName());
    }

    @Test
    @Ignore
    public void testGetAttachmentMeta() throws ExecutionException, InterruptedException {
        final Future<AttachmentMetaBean> future = jiraRestClient.getSystemClient().getAttachmentMeta();
        final AttachmentMetaBean attachmentMetaBean = future.get();
        Assert.assertNotNull(attachmentMetaBean);
        Assert.assertEquals(DEFAULT_UPLOAD_LIMIT, attachmentMetaBean.getUploadLimit());
    }


}
