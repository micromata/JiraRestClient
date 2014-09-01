package de.micromata.jira.rest.client;

import de.micromata.jira.rest.core.domain.BasicProjectBean;
import de.micromata.jira.rest.core.domain.ComponentBean;
import de.micromata.jira.rest.core.domain.ProjectBean;
import de.micromata.jira.rest.core.domain.VersionBean;
import de.micromata.jira.rest.core.util.RestException;

import java.io.IOException;
import java.util.List;

/**
 * The IssueClient provides all Informations for Jira Issues
 * <p/>
 * Author: Christian Schulze c.schulze@micromata.de
 */
public interface ProjectClient {


    /**
     * Returns a list of all projects the logged in User can see..
     *
     * @return list of projects
     * @throws RestException
     */
    public List<BasicProjectBean> getAllProjects() throws RestException, IOException;

    /**
     * Returns a full representation of the project for the given key.
     *
     * @param projectKey = the project key
     * @return all informations for the project
     * @throws RestException
     */
    public ProjectBean getProjectByKey(String projectKey) throws RestException, IOException;

    /**
     * Returns a list of all versions for a project.
     *
     * @param projectKey = the project key
     * @return list of versions
     * @throws RestException
     */
    public List<VersionBean> getProjectVersions(String projectKey) throws RestException, IOException;


    /**
     * Returns a list of all components for a project.
     *
     * @param projectKey = the project key
     * @return list of components
     * @throws RestException
     */
    public List<ComponentBean> getProjectComponents(String projectKey) throws RestException, IOException;


    /**
     * Returns a Component by id
     *
     * @param id The id of the Component
     * @return The ComponentBean or null if it doesn't exist.
     * @throws RestException
     */
    public ComponentBean getComponentById(long id) throws RestException;

    /**
     * Return a Version by id
     *
     * @param id
     * @return The VersionBean or null if it doesn't exist.
     * @throws RestException
     */
    public VersionBean getVersionById(long id) throws RestException;

    /**
     * Modify a component via PUT. Any fields present in the PUT will override existing values.
     * As a convenience, if a field is not present, it is silently ignored. If leadUserName is an empty string ("") the component lead will be removed.
     *
     * @param componentBean The ComponentBean to update
     * @return The updated ComponentBean
     * @throws RestException
     */
    public ComponentBean updateComponent(ComponentBean componentBean) throws RestException;

    /**
     * Modify a version via PUT. Any fields present in the PUT will override existing values. As a convenience, if a field is not present, it is silently ignored.
     *
     * @param versionBean The VersionBean to update
     * @return The updated VersionBean
     * @throws RestException
     */
    public VersionBean updateVersion(VersionBean versionBean) throws RestException;

}
