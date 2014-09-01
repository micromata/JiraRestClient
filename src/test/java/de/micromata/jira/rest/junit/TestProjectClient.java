package de.micromata.jira.rest.junit;

import de.micromata.jira.rest.core.domain.BasicProjectBean;
import de.micromata.jira.rest.core.domain.ComponentBean;
import de.micromata.jira.rest.core.domain.ProjectBean;
import de.micromata.jira.rest.core.domain.VersionBean;
import de.micromata.jira.rest.core.util.RestException;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 10.08.2014
 */
public class TestProjectClient extends BaseTest {


    @Test
    public void testGetProjectByKey() throws RestException, IOException {
        ProjectBean projectBean = jiraRestClient.getProjectClient().getProjectByKey(PROJECT_TO_SEARCH);
        Assert.assertNotNull(projectBean);
        Assert.assertEquals(PROJECT_TO_SEARCH, projectBean.getKey());
    }

    @Test
    public void testGetAllProjects() throws RestException, IOException {
        List<BasicProjectBean> allProjects = jiraRestClient.getProjectClient().getAllProjects();
        Assert.assertNotNull(allProjects);
        Assert.assertFalse(allProjects.isEmpty());
    }

    @Test
    public void testGetProjectVersions() throws RestException, IOException {
        List<VersionBean> projectVersions = jiraRestClient.getProjectClient().getProjectVersions(PROJECT_TO_SEARCH);
        Assert.assertNotNull(projectVersions);
//        Assert.assertFalse(projectVersions.isEmpty());
    }

    @Test
    public void testGetProjectComponents() throws RestException, IOException {
        List<ComponentBean> projectComponents = jiraRestClient.getProjectClient().getProjectComponents(PROJECT_TO_SEARCH);
        Assert.assertNotNull(projectComponents);
//        Assert.assertFalse(projectComponents.isEmpty());
    }
}
