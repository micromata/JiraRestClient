
package de.micromata.jira.rest.core.domain.field;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class FieldBean {

    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private Boolean custom;
    @Expose
    private Boolean orderable;
    @Expose
    private Boolean navigable;
    @Expose
    private Boolean searchable;
    @Expose
    private List<String> clauseNames = new ArrayList<String>();
    @Expose
    private Schema schema;

    public List<String> getClauseNames() {
        return clauseNames;
    }

    public void setClauseNames(List<String> clauseNames) {
        this.clauseNames = clauseNames;
    }

    public Boolean getCustom() {
        return custom;
    }

    public void setCustom(Boolean custom) {
        this.custom = custom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNavigable() {
        return navigable;
    }

    public void setNavigable(Boolean navigable) {
        this.navigable = navigable;
    }

    public Boolean getOrderable() {
        return orderable;
    }

    public void setOrderable(Boolean orderable) {
        this.orderable = orderable;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }
}
