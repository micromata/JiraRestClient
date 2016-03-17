package de.micromata.jira.rest.core.domain.meta;

import com.google.gson.annotations.Expose;
import de.micromata.jira.rest.core.domain.BaseBean;
import de.micromata.jira.rest.core.domain.ProjectBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cschulc on 16.03.16.
 */
public class MetaBean extends BaseBean {

    @Expose
    private List<ProjectMetaBean> projects = new ArrayList<>();

    public List<ProjectMetaBean> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectMetaBean> projects) {
        this.projects = projects;
    }
}
