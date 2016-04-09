package de.micromata.jira.rest.client;

import de.micromata.jira.rest.core.domain.AttachmentMetaBean;
import de.micromata.jira.rest.core.domain.IssuetypeBean;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.StatusBean;
import de.micromata.jira.rest.core.domain.field.CreateFieldBean;
import de.micromata.jira.rest.core.domain.field.FieldBean;
import de.micromata.jira.rest.core.util.RestException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;

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
    Future<List<IssuetypeBean>> getIssueTypes() throws RestException, IOException;

    /**
     * Returns a list of all statuses.
     *
     * @return list of statuses
     * @throws RestException
     */
    Future<List<StatusBean>> getStates() throws RestException, IOException;


    /**
     * Returns a List of all Priority Object from the Remote Jira.
     *
     * @return
     * @throws RestException
     */
    Future<List<PriorityBean>> getPriorities() throws RestException, IOException;


    /**
     * Return a List of all Field configure in Jira, standard and custom
     *
     * @return a List of FieldBean
     */
    Future<List<FieldBean>> getAllFields();


    /**
     * Return all Custom Field configure in the Jira
     *
     * @return a List of FieldBean
     */
    Future<List<FieldBean>> getAllCustomFields();

    /**
     * Return a Custom Field by Id
     *
     */
    Future<FieldBean> getCustomFieldById(String id);


    /**
     * Get the Attachment Meta Information for the jira instanz
     *
     * @return AttachmentMetaBean
     */
    Future<AttachmentMetaBean> getAttachmentMeta();

    /**
     * Creates a Custom Field
     *
     * @param fieldBean The CreateFieldBean with the create Informations
     * @return The created Field as FieldBean
     */
    Future<FieldBean> createCustomField(CreateFieldBean fieldBean);

}
