package de.micromata.jira.rest.junit;

import de.micromata.jira.rest.core.domain.Component;
import de.micromata.jira.rest.core.domain.Project;
import de.micromata.jira.rest.core.domain.Version;
import de.micromata.jira.rest.core.util.RestException;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 10.08.2014
 */
public class TestProjectClient extends BaseTest {


    @Test
    public void testGetProjectByKey() throws RestException, IOException {
        Project project = jiraRestClient.getProjectClient().getProjectByKey(PROJECT_TO_SEARCH);
        Assert.assertNotNull(project);
        Assert.assertEquals(PROJECT_TO_SEARCH, project.getKey());
    }

    @Test
    public void testGetAllProjects() throws RestException, IOException {
        List<Project> allProjects = jiraRestClient.getProjectClient().getAllProjects();
        Assert.assertNotNull(allProjects);
        Assert.assertFalse(allProjects.isEmpty());
    }

    @Test
    public void testGetProjectVersions() throws RestException, IOException {
        List<Version> projectVersions = jiraRestClient.getProjectClient().getProjectVersions(PROJECT_TO_SEARCH);
        Assert.assertNotNull(projectVersions);
//        Assert.assertFalse(projectVersions.isEmpty());
    }

    @Test
    public void testGetProjectComponents() throws RestException, IOException {
        List<Component> projectComponents = jiraRestClient.getProjectClient().getProjectComponents(PROJECT_TO_SEARCH);
        Assert.assertNotNull(projectComponents);
//        Assert.assertFalse(projectComponents.isEmpty());
    }
}
