package de.micromata.jira.rest.jql;

import org.apache.commons.lang3.StringUtils;

/**
 * JQL clause is a part of a query. A query has three basic parts: fields, operators, and operands(=values).
 * You can optionally link them together using a few select keywords.
 * 
 * <p>JQLClause = ( field + operator + operand ) + keyword + ...
 * <p>Example: ( PROJECT = DEMO ) + AND ...
 * 
 */
public class JqlClause {

	/** Field type of information. */
	private EField field = null;
	
	/** The operator relate the field to the operand. */
	private EOperator operator = null;
	
	/** The the actual data for the field. */
	private String operand = StringUtils.EMPTY;
	
	/** The keyword to link the JQL clause. */
	private EKeyword keyword = null;
	
	/**
	 * Instantiates a new jql clause.
	 *
	 * @param field = type of information
	 * @param operator = link between field and operand
	 * @param operand = actual data
	 * @param keyword = link to another clause (should be null, if there is nothing to link)
	 */
	public JqlClause(EField field, EOperator operator, String operand,
			EKeyword keyword) {
		this.field = field;
		this.operator = operator;
		this.operand = operand;
		this.keyword = keyword;
	}

	/**
	 * Gets the field.
	 *
	 * @return the field
	 */
	public EField getField() {
		return field;
	}

	/**
	 * Sets the field.
	 *
	 * @param field the new field
	 */
	public void setField(EField field) {
		this.field = field;
	}

	/**
	 * Gets the operator.
	 *
	 * @return the operator
	 */
	public EOperator getOperator() {
		return operator;
	}

	/**
	 * Sets the operator.
	 *
	 * @param operator the new operator
	 */
	public void setOperator(EOperator operator) {
		this.operator = operator;
	}

	/**
	 * Gets the operand.
	 *
	 * @return the operand
	 */
	public String getOperand() {
		return operand;
	}

	/**
	 * Sets the operand.
	 *
	 * @param operand the new operand
	 */
	public void setOperand(String operand) {
		this.operand = operand;
	}

	/**
	 * Gets the keyword.
	 *
	 * @return the keyword
	 */
	public EKeyword getKeyword() {
		return keyword;
	}

	/**
	 * Sets the keyword.
	 *
	 * @param keyword the new keyword
	 */
	public void setKeyword(EKeyword keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(field != null) {
			sb.append(field);
		}
		if(operator != null) {
			sb.append(operator);
		}
		if(operand != null) {
			sb.append(" " + operand);
		}
		if(keyword != null) {
			sb.append(keyword);
		}
		
		return sb.toString();
	}
}
