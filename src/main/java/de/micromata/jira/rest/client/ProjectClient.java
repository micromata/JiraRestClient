package de.micromata.jira.rest.client;

import de.micromata.jira.rest.core.domain.Component;
import de.micromata.jira.rest.core.domain.Project;
import de.micromata.jira.rest.core.domain.Version;
import de.micromata.jira.rest.core.util.RestException;

import java.io.IOException;
import java.util.List;

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
    public List<Project> getAllProjects() throws RestException, IOException;

    /**
     * Returns a full representation of the project for the given key.
     *
     * @param projectKey = the project key
     * @return all informations for the project
     * @throws RestException
     */
    public Project getProjectByKey(String projectKey) throws RestException, IOException;

    /**
     * Returns a list of all versions for a project.
     *
     * @param projectKey = the project key
     * @return list of versions
     * @throws RestException
     */
    public List<Version> getProjectVersions(String projectKey) throws RestException, IOException;


    /**
     * Returns a list of all components for a project.
     *
     * @param projectKey = the project key
     * @return list of components
     * @throws RestException
     */
    public List<Component> getProjectComponents(String projectKey) throws RestException, IOException;

}
