package de.micromata.jira.rest.client;

import de.micromata.jira.rest.core.domain.IssueTypeBean;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.StatusBean;
import de.micromata.jira.rest.core.util.RestException;

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
    public List<IssueTypeBean> getIssueTypes() throws RestException;

    /**
     * Returns a list of all statuses.
     *
     * @return list of statuses
     * @throws RestException
     */
    public List<StatusBean> getStates() throws RestException;


    /**
     * Returns a List of all Priority Object from the Remote Jira.
     *
     * @return
     * @throws RestException
     */
    public List<PriorityBean> getPriorities() throws RestException;

}
