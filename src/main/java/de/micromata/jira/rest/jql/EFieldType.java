/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.jql;

import java.util.Arrays;
import java.util.List;

import static de.micromata.jira.rest.jql.EOperator.*;

/**
 * The type of a field sets the supporting operators.
 *
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public enum EFieldType {

	/** The version. */
	VERSION(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED), 
	
	/** The user. */
	USER(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED), 
	
	/** The category. */
	CATEGORY(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN), 
	
	/** The text. */
	TEXT(CONTAINS, DOES_NOT_CONTAIN, IS, IS_NOT), 
	
	/** The component. */
	COMPONENT(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN), 
	
	/** The date. */
	DATE(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT), 
	
	/** The filter. */
	FILTER(EQUALS, NOT_EQUALS, IN, NOT_IN), 
	
	/** The issue. */
	ISSUE(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT), 
	
	/** The security level. */
	SECURITY_LEVEL(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN), 
	
	/** The duration. */
	DURATION(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT), 
	
	/** The priority. */
	PRIORITY(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED), 
	
	/** The project. */
	PROJECT(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN), 
	
	/** The resolution. */
	RESOLUTION(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED), 
	
	/** The number. */
	NUMBER(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN), 
	
	/** The status. */
	STATUS(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED), 
	
	/** The text master. */
	TEXT_MASTER(CONTAINS), 
	
	/** The issue type. */
	ISSUE_TYPE(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN), 
	
	/** The custom type. */
	CUSTOM_TYPE;
	
	/** List of supported operators for a type of field. */
	private final List<EOperator> supportedOperators;
	
	/**
	 * Instantiates a new field type.
	 *
	 * @param supportedOpperator = the supported operators for a type
	 */
	private EFieldType(EOperator ... supportedOperators) {
		this.supportedOperators = Arrays.asList(supportedOperators);
	}

	/**
	 * Gets the list of supported opperators.
	 *
	 * @return the supported opperators
	 */
	public List<EOperator> getSupportedOperators() {
		return supportedOperators;
	}
}
