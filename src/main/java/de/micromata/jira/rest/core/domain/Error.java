package de.micromata.jira.rest.core.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.*;

/**
 * Created by Christian on 02.07.2014.
 */
public class Error {

    private List<String> errorMessages = new ArrayList<String>();

    private Map<String, String> errors = new HashMap<String, String>();

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
