/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.jql;

/**
 * JQL builder
 * 
 * <p>JQL condition = ( field + operator + operand ) + JqlKeyword + ...
 * <p>Example: ( PROJECT = DEMO ) + AND ...
 *
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 * 
 */
public class JqlBuilder {
	
	private StringBuffer jql = null;
	
	public JqlBuilder() {
		jql = new StringBuffer();
	}
	
	public JqlKeyword addCondition(EField field, EOperator operator, String operand) {
		JqlKeyword jqlKeyword = new JqlKeyword();
		
		if(field != null) {
			jql.append(field + " ");
		}
		if(operator != null) {
			jql.append(operator + " ");
		}
		if(operand != null) {
			jql.append(operand + " ");
		}
		
		return jqlKeyword;
	}
	
	public JqlBuilder getJqlBuilder() {
		return this;
	}
	
	public void clear() {
		jql.setLength(0);
	}
	
	public class JqlKeyword {
		
		public JqlBuilder and() {
			jql.append(EKeyword.AND + " ");
			return getJqlBuilder();
		}
		
		public JqlBuilder or() {
			jql.append(EKeyword.OR + " ");
			return getJqlBuilder();
		}
		
		public String orderBy(SortOrder order, EField ... fields) {
			if(fields == null || order == null || fields.length == 0) {
				return build();
			}
			
			jql.append(EKeyword.ORDER_BY + " ");
			jql.append(fields[0]);
			
			for(int i = 1;i < fields.length;i++) {
				jql.append(", ");
				jql.append(fields[i]);
			}
			
			jql.append(" " + order);
			
			return build();
		}
		
		/**
		 * Return the request String and clear the buffer.
		 * 
		 * @return
		 */
		public String build() {
			String request = jql.toString();
			clear();
			return request;
		}
	}
}
