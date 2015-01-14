package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class Item {

    @Expose
    private String field;
    @Expose
    private String fieldtype;
    @Expose
    private String from;
    @Expose
    private String fromString;
    @Expose
    private String to;
    @Expose
    private String toString;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldtype() {
        return fieldtype;
    }

    public void setFieldtype(String fieldtype) {
        this.fieldtype = fieldtype;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromString() {
        return fromString;
    }

    public void setFromString(String fromString) {
        this.fromString = fromString;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToString() {
        return toString;
    }

    public void setToString(String toString) {
        this.toString = toString;
    }
}
