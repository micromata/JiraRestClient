package de.micromata.jira.rest.core.domain.meta.fields;

import com.google.gson.annotations.Expose;
import de.micromata.jira.rest.core.domain.IssuetypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cschulc on 16.03.16.
 */
public class IssueTypeFieldMetaBean extends FieldMetaBean {

    @Expose
    private List<IssuetypeBean> allowedValues = new ArrayList<>();

    public List<IssuetypeBean> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<IssuetypeBean> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
