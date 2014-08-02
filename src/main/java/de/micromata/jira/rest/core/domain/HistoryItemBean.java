package de.micromata.jira.rest.core.domain;

import org.apache.commons.lang3.StringUtils;

public class HistoryItemBean {

	private String field = StringUtils.EMPTY;

	private String fieldType = StringUtils.EMPTY;

	private String from = StringUtils.EMPTY;

	private String fromString = StringUtils.EMPTY;

	private String to = StringUtils.EMPTY;

	private String toString = StringUtils.EMPTY;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
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
