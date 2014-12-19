
package de.micromata.jira.rest.core.domain.field;

import com.google.gson.annotations.Expose;


public class Schema {

    @Expose
    private String type;
    @Expose
    private String system;

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
