package de.micromata.jira.rest.core.domain.meta.fields;

import com.google.gson.annotations.Expose;
import de.micromata.jira.rest.core.domain.ComponentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cschulc on 16.03.16.
 */
public class ComponentFieldMetaBean extends FieldMetaBean {

    @Expose
    private List<ComponentBean> allowedValues = new ArrayList<>();

    public List<ComponentBean> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<ComponentBean> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
