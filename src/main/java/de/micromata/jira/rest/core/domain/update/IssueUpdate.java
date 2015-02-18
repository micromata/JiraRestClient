package de.micromata.jira.rest.core.domain.update;

import com.google.gson.annotations.Expose;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 29.10.2014
 */
public class IssueUpdate {

    @Expose
    private Map<String, Object> fields = new HashMap<String, Object>();
    @Expose
    private Map<String, List<FieldOperation>> update = new HashMap<String, List<FieldOperation>>();

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }

    public Map<String, List<FieldOperation>> getUpdate() {
        return update;
    }

    public void setUpdate(Map<String, List<FieldOperation>> update) {
        this.update = update;
    }
}
