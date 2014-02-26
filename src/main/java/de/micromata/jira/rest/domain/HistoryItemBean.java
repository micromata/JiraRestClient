package de.micromata.jira.rest.domain;

import org.apache.commons.lang3.StringUtils;

public class HistoryItemBean {

	private String field = StringUtils.EMPTY;
	
	private String fieldType = StringUtils.EMPTY;
	
	private int from = 0;
	
	private String fromString = StringUtils.EMPTY;
	
	private int to = 0;
	
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

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public String getFromString() {
		return fromString;
	}

	public void setFromString(String fromString) {
		this.fromString = fromString;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public String getToString() {
		return toString;
	}

	public void setToString(String toString) {
		this.toString = toString;
	}
}
