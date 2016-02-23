package de.micromata.jira.rest.core.domain.customFields;

import de.micromata.jira.rest.core.domain.ProjectBean;

/**
 * Created by cschulc on 22.02.16.
 */
public class ProjectSelectBean extends CustomFieldBaseBean {

    private ProjectBean project;

    public ProjectBean getProject() {
        return project;
    }

    public void setProject(ProjectBean project) {
        this.project = project;
    }
}
