package de.micromata.jira.rest.core.domain.meta.fields;

import com.google.gson.annotations.Expose;
import de.micromata.jira.rest.core.domain.ProjectBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cschulc on 16.03.16.
 */
public class ProjectFieldMetaBean extends FieldMetaBean {

    @Expose
    private List<ProjectBean> allowedValues = new ArrayList<>();

    public List<ProjectBean> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<ProjectBean> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
