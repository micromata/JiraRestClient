package de.micromata.jira.rest.core.domain.meta;

import com.google.gson.annotations.Expose;
import de.micromata.jira.rest.core.domain.IssuetypeBean;

/**
 * Created by cschulc on 16.03.16.
 */
public class IssueTypeMetaBean extends IssuetypeBean {

    @Expose
    private FieldsMetaBean fields;

    public FieldsMetaBean getFields() {
        return fields;
    }

    public void setFields(FieldsMetaBean fields) {
        this.fields = fields;
    }
}
