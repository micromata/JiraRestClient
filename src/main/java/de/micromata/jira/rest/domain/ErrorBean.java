package de.micromata.jira.rest.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Christian on 02.07.2014.
 */
public class ErrorBean {

    private Collection<String> errorMessages = new ArrayList<String>();

    private Map<String, String> errors = new HashMap<String, String>();

    public Collection<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Collection<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
