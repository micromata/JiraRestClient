package de.micromata.jira.rest.core.domain.meta.custom;

import de.micromata.jira.rest.core.domain.meta.fields.FieldMetaBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cschulc on 16.03.16.
 */
public class ValuesCustomFieldMetaBean extends FieldMetaBean {

    private List<ValueMetaBean> allowedValues = new ArrayList<>();

    public ValuesCustomFieldMetaBean(FieldMetaBean fieldMetaBean) {
        super(fieldMetaBean);
    }

    public List<ValueMetaBean> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<ValueMetaBean> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
