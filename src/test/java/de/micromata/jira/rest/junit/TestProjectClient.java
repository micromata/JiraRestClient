package de.micromata.jira.rest.junit;

import de.micromata.jira.rest.core.domain.ComponentBean;
import de.micromata.jira.rest.core.domain.ProjectBean;
import de.micromata.jira.rest.core.domain.VersionBean;
import de.micromata.jira.rest.core.domain.meta.MetaBean;
import de.micromata.jira.rest.core.util.RestException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 10.08.2014
 */
public class TestProjectClient extends BaseTest {


    @Test
    public void testGetProjectByKey() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<ProjectBean> future = jiraRestClient.getProjectClient().getProjectByKey(PROJECT_TO_SEARCH);
        final ProjectBean project = future.get();
        Assert.assertNotNull(project);
        Assert.assertEquals(PROJECT_TO_SEARCH, project.getKey());
    }

    @Test
    public void testGetAllProjects() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<List<ProjectBean>> future = jiraRestClient.getProjectClient().getAllProjects();
        final List<ProjectBean> projectBeans = future.get();
        Assert.assertNotNull(projectBeans);
        Assert.assertFalse(projectBeans.isEmpty());
    }

    @Test
    public void testGetProjectVersions() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<List<VersionBean>> future = jiraRestClient.getProjectClient().getProjectVersions(PROJECT_TO_SEARCH);
        final List<VersionBean> versionBeans = future.get();
        Assert.assertNotNull(versionBeans);
        Assert.assertTrue(versionBeans.isEmpty());
    }

    @Test
    public void testGetProjectComponents() throws RestException, IOException, ExecutionException, InterruptedException {
        final Future<List<ComponentBean>> future = jiraRestClient.getProjectClient().getProjectComponents(PROJECT_TO_SEARCH);
        final List<ComponentBean> componentBeans = future.get();
        Assert.assertNotNull(componentBeans);
        Assert.assertTrue(componentBeans.isEmpty());
    }

    @Test
    public void testGetIssueTypesMetaForProject() throws ExecutionException, InterruptedException {
        Future<MetaBean> future = jiraRestClient.getProjectClient().getIssueTypesMetaForProject(PROJECT_TO_SEARCH);
        MetaBean metaBean = future.get();
        Assert.assertNotNull(metaBean);
    }
}
