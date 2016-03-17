package de.micromata.jira.rest.core.domain.meta.fields;

import com.google.gson.annotations.Expose;
import de.micromata.jira.rest.core.domain.meta.SchemaMetaBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cschulc on 16.03.16.
 */
public class FieldMetaBean {

    @Expose
    private Boolean required;
    @Expose
    private SchemaMetaBean schema;
    @Expose
    private String name;
    @Expose
    private Boolean hasDefaultValue;
    @Expose
    private List<String> operations = new ArrayList<String>();

    public FieldMetaBean() {
    }

    public FieldMetaBean(FieldMetaBean fieldMetaBean) {
        this.schema = fieldMetaBean.getSchema();
        this.setName(fieldMetaBean.getName());
        this.setHasDefaultValue(fieldMetaBean.getHasDefaultValue());
        this.setOperations(fieldMetaBean.getOperations());
        this.setRequired(fieldMetaBean.getRequired());
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public SchemaMetaBean getSchema() {
        return schema;
    }

    public void setSchema(SchemaMetaBean schema) {
        this.schema = schema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHasDefaultValue() {
        return hasDefaultValue;
    }

    public void setHasDefaultValue(Boolean hasDefaultValue) {
        this.hasDefaultValue = hasDefaultValue;
    }

    public List<String> getOperations() {
        return operations;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }
}
