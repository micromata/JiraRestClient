package de.micromata.jira.rest.core.domain.meta.custom;

import com.google.gson.annotations.Expose;
import de.micromata.jira.rest.core.domain.meta.fields.FieldMetaBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cschulc on 17.03.16.
 */
public class CascadingCustomFieldMetaBean extends FieldMetaBean {

    @Expose
    private List<ValueMetaBean> allowedValues = new ArrayList<>();

    public List<ValueMetaBean> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<ValueMetaBean> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
