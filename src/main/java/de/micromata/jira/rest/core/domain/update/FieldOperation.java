package de.micromata.jira.rest.core.domain.update;

/**
 * User: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 29.10.2014
 */
public class FieldOperation {

    private String operation;
    private Object value;

    public FieldOperation()
    {
    }

    public FieldOperation(String operation, Object value)
    {
        this.operation = operation;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
