package de.micromata.jira.rest.client;

import de.micromata.jira.rest.core.domain.ComponentBean;
import de.micromata.jira.rest.core.domain.ProjectBean;
import de.micromata.jira.rest.core.domain.VersionBean;
import de.micromata.jira.rest.core.util.RestException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;

/**
 * The IssueClient provides all Informations for Jira Issues
 * <p/>
 * User: Christian Schulze c.schulze@micromata.de
 */
public interface ProjectClient {


    /**
     * Returns a list of all projects the logged in User can see..
     *
     * @return list of projects
     * @throws RestException
     */
    Future<List<ProjectBean>> getAllProjects() throws RestException, IOException;

    /**
     * Returns a full representation of the project for the given key.
     *
     * @param projectKey = the project key
     * @return all informations for the project
     * @throws RestException
     */
    Future<ProjectBean> getProjectByKey(final String projectKey) throws RestException, IOException;

    /**
     * Returns a list of all versions for a project.
     *
     * @param projectKey = the project key
     * @return list of versions
     * @throws RestException
     */
    Future<List<VersionBean>> getProjectVersions(final String projectKey) throws RestException, IOException;


    /**
     * Returns a list of all components for a project.
     *
     * @param projectKey = the project key
     * @return list of components
     * @throws RestException
     */
    Future<List<ComponentBean>> getProjectComponents(final String projectKey) throws RestException, IOException;

}
