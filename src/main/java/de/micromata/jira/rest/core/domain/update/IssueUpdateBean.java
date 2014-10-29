package de.micromata.jira.rest.core.domain.update;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 29.10.2014
 */
public class IssueUpdateBean {

    private Map<String, Object> fields = new HashMap<String, Object>();

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
