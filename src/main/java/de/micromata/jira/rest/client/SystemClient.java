package de.micromata.jira.rest.client;

import de.micromata.jira.rest.core.domain.Issuetype;
import de.micromata.jira.rest.core.domain.Priority;
import de.micromata.jira.rest.core.domain.Status;
import de.micromata.jira.rest.core.util.RestException;

import java.io.IOException;
import java.util.List;

/**
 * The SystemClient provides all Information about the Jira System Configuration
 */
public interface SystemClient {


    /**
     * Returns a list of all issue types visible to the connected client.
     *
     * @return list of issue types
     * @throws de.micromata.jira.rest.core.util.RestException
     */
    public List<Issuetype> getIssueTypes() throws RestException, IOException;

    /**
     * Returns a list of all statuses.
     *
     * @return list of statuses
     * @throws RestException
     */
    public List<Status> getStates() throws RestException, IOException;


    /**
     * Returns a List of all Priority Object from the Remote Jira.
     *
     * @return
     * @throws RestException
     */
    public List<Priority> getPriorities() throws RestException, IOException;

}
