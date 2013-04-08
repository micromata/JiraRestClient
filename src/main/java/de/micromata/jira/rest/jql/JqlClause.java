package de.micromata.jira.rest.jql;

import org.apache.commons.lang3.StringUtils;

public class JqlClause {

	private EField field = null;
	
	private EOperator operator = null;
	
	private String operand = StringUtils.EMPTY;
	
	private EKeyword keyword = null;
	
	public JqlClause(EField field, EOperator operator, String operand,
			EKeyword keyword) {
		this.field = field;
		this.operator = operator;
		this.operand = operand;
		this.keyword = keyword;
	}

	public EField getField() {
		return field;
	}

	public void setField(EField field) {
		this.field = field;
	}

	public EOperator getOperator() {
		return operator;
	}

	public void setOperator(EOperator operator) {
		this.operator = operator;
	}

	public String getOperand() {
		return operand;
	}

	public void setOperand(String operand) {
		this.operand = operand;
	}

	public EKeyword getKeyword() {
		return keyword;
	}

	public void setKeyword(EKeyword keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(field != null) {
			sb.append(field + " ");
		}
		if(operator != null) {
			sb.append(operator + " ");
		}
		if(operand != null) {
			sb.append(operand + " ");
		}
		if(keyword != null) {
			sb.append(keyword + " ");
		}
		
		return sb.toString();
	}
}
