package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ErrorBean {

    @Expose
    private List<Object> errorMessages = new ArrayList<Object>();
    @Expose
    private ErrorsBean errors;

    public ErrorsBean getErrors() {
        return errors;
    }

    public void setErrors(ErrorsBean errors) {
        this.errors = errors;
    }

    public List<Object> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<Object> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
