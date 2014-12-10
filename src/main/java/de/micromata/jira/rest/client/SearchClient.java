package de.micromata.jira.rest.client;

import de.micromata.jira.rest.core.domain.JqlSearchResult;
import de.micromata.jira.rest.core.jql.JqlSearchBean;
import de.micromata.jira.rest.core.util.RestException;

import java.io.IOException;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 31.07.2014
 */
public interface SearchClient {

    /**
     * Performs an extended search for issues given by the project.
     *
     * @return list of issues
     * @throws de.micromata.jira.rest.core.util.RestException
     */
    public Future<JqlSearchResult> searchIssues(JqlSearchBean jsb) throws RestException, IOException;
}
