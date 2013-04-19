package de.micromata.jira.rest.jql;

import com.atlassian.query.order.SortOrder;


/**
 * JQL clause is a part of a query. A query has three basic parts: fields, operators, and operands(=values).
 * You can optionally link them together using a few select keywords.
 * 
 * <p>JQLClause = ( field + operator + operand ) + keyword + ...
 * <p>Example: ( PROJECT = DEMO ) + AND ...
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
		
		public String build() {
			return jql.toString();
		}
	}
}
