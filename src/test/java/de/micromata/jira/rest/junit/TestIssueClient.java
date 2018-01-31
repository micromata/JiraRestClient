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
public class TestIssueClient extends BaseTest {

    private static final String NEW_LINE = System.getProperty("line.separator");


    @Test
    public void testGetIssueByKey() throws IOException, RestException, ExecutionException, InterruptedException {
        Future<IssueBean> future = jiraRestClient.getIssueClient().getIssueByKey(ISSUEKEY_TO_SEARCH);
        Map<String, FieldBean> customfields = JiraRestClient.getCustomfields();
        final IssueBean issueBean = future.get();
        Assert.assertNotNull(issueBean);
        Assert.assertEquals(ISSUEKEY_TO_SEARCH, issueBean.getKey());
    }


    @Test
    public void testGetIssueKeyWithFields() throws RestException, IOException, ExecutionException, InterruptedException {
        List<String> field = new ArrayList<>();
        field.add(EField.SUMMARY.getField());
        field.add(EField.DESCRIPTION.getField());
        List<String> expand = new ArrayList<>();
        expand.add(EField.RENDEREDFIELDS.getField());
        expand.add(EField.TRANSITIONS.getField());
        expand.add(EField.CHANGELOG.getField());
        final Future<IssueBean> future = jiraRestClient.getIssueClient().getIssueByKey(ISSUEKEY_TO_SEARCH, field, expand);
        IssueBean issue = future.get();
        Assert.assertNotNull(issue);
        Assert.assertNotNull(issue.getFields().getSummary());
        Assert.assertNotNull(issue.getFields().getDescription());
        Assert.assertNotNull(issue.getRenderedFields().getDescription());

    }


    @Test
    public void testGetAttachment() throws IOException, RestException, ExecutionException, InterruptedException {
        final Future<IssueBean> future = jiraRestClient.getIssueClient().getIssueByKey(ISSUEKEY_TO_SEARCH);
        final IssueBean issue = future.get();
        List<AttachmentBean> attachments = issue.getFields().getAttachment();
        Assert.assertNotNull(attachments);
        Assert.assertFalse(attachments.isEmpty());
        AttachmentBean attachment = attachments.get(0);
        String fileName = attachment.getFilename();
        String contentURI = attachment.getContent();
        URI uri = URIHelper.parseStringToURI(contentURI);
        final Future<Byte[]> future1 = jiraRestClient.getIssueClient().getAttachment(uri);

        final Byte[] attachmentBytes = future1.get();
        Assert.assertNotNull(attachmentBytes);
        OutputStream output = new FileOutputStream(fileName);
        final byte[] bytes = ArrayUtils.toPrimitive(attachmentBytes);
        output.write(bytes);
        output.flush();
        output.close();


    }


    @Test
    public void testCreateIssue() throws RestException, IOException, ExecutionException, InterruptedException {
        IssueBean issue = new IssueBean();
        FieldsBean fields = new FieldsBean();
        fields.setDescription("Test Description");
        fields.setSummary("Test Title");
        ProjectBean project = new ProjectBean();
        project.setKey("DEMO");
        fields.setProject(project);
        IssuetypeBean issueType = new IssuetypeBean();
        issueType.setName("Bug");
        fields.setIssuetype(issueType);
        PriorityBean priority = new PriorityBean();
        priority.setName(JsonConstants.PRIORITY_MAJOR);
        fields.setPriority(priority);
        fields.setDuedate("2015-08-01");

        List<ComponentBean> componentBeen = new ArrayList<>();
        ComponentBean componentBean1 = new ComponentBean();
        componentBean1.setName("Komponente 1");
        componentBeen.add(componentBean1);
        ComponentBean componentBean2 = new ComponentBean();
        componentBean2.setName("Komponente 2");
        componentBeen.add(componentBean2);
        fields.setComponents(componentBeen);

        List<VersionBean> versionBeen = new ArrayList<>();
        VersionBean versionBean1 = new VersionBean();
        versionBean1.setName("1.1");
        versionBeen.add(versionBean1);
        VersionBean versionBean2 = new VersionBean();
        versionBean2.setName("1.0");
        versionBeen.add(versionBean2);
        fields.setVersions(versionBeen);
        fields.setFixVersions(versionBeen);

        UserBean userBean = new UserBean();
        userBean.setName("admin");
        fields.setAssignee(userBean);
        List<String> labels = new ArrayList<>();
        labels.add("foobar");
        labels.add("inubit");
        fields.setLabels(labels);
        issue.setFields(fields);

        final Future<IssueResponse> future = jiraRestClient.getIssueClient().createIssue(issue);
        final IssueResponse issueResponse = future.get();
        if (issueResponse != null) {
            String issueKey = issueResponse.getKey();
            if (issueKey != null) {
                System.out.println(issueKey);
            } else {
                System.out.println(issueResponse.getError());
            }
        }


    }

    @Test
    public void testSetLinkInEviroment() throws IOException, RestException, ExecutionException, InterruptedException {
        final Future<IssueBean> future = jiraRestClient.getIssueClient().getIssueByKey(ISSUEKEY_TO_SEARCH);
        final IssueBean issue = future.get();
        Assert.assertNotNull(issue);
        Assert.assertEquals(ISSUEKEY_TO_SEARCH, issue.getKey());
        String environment = issue.getFields().getEnvironment();
        String newEnviroment = environment + NEW_LINE + NEW_LINE + issue.getSelf();
        IssueUpdate issueUpdate = new IssueUpdate();
        Map<String, List<FieldOperation>> update = issueUpdate.getUpdate();
        List<FieldOperation> operations = new ArrayList<>();
        operations.add(new FieldOperation(Operation.SET.getName(), newEnviroment));
        update.put(JsonConstants.PROP_ENVIRONMENT, operations);
        final Future<IssueBean> updateFuture = jiraRestClient.getIssueClient().updateIssue(ISSUEKEY_TO_SEARCH, issueUpdate);

        final IssueBean issueBean = updateFuture.get();
        String updateIssueEnvironment = issueBean.getFields().getEnvironment();
        Assert.assertEquals(newEnviroment, updateIssueEnvironment);

    }

    @Test
    public void testGetTransitions() throws ExecutionException, InterruptedException, IOException, RestException {
        final Future<List<TransitionBean>> future = jiraRestClient.getIssueClient().getIssueTransitionsByKey(ISSUEKEY_TO_SEARCH);
        final List<TransitionBean> transitionBeans = future.get();
        Assert.assertNotNull(transitionBeans);
        Assert.assertFalse(transitionBeans.isEmpty());
    }

    @Test
    public void testSaveAttachment() throws IOException, RestException, ExecutionException, InterruptedException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("fields.json")).getFile());
        File file2  = new File(Objects.requireNonNull(classLoader.getResource("customfields.json")).getFile());
        if(file.exists() == true){
            Future<List<AttachmentBean>> listFuture = jiraRestClient.getIssueClient().saveAttachmentToIssue(ISSUEKEY_TO_SEARCH, file, file2);
            List<AttachmentBean> attachmentBeen = listFuture.get();
            Assert.assertFalse(attachmentBeen.isEmpty());
        }
    }

    @Test
    public void testAddCommentToIssue() throws URISyntaxException, IOException, RestException {
        CommentBean commentBean = new CommentBean();
        commentBean.setBody("This is a new comment via JiraRestClient.");
        boolean commentToIssue = jiraRestClient.getIssueClient().addCommentToIssue(ISSUEKEY_TO_SEARCH, commentBean);
        Assert.assertTrue(commentToIssue);
    }
}
