package de.micromata.jira.rest.jql;

import java.util.ArrayList;
import java.util.List;

public class JqlSearchBean {

	private Integer startAt = null;

    private Integer maxResult = null;
    
    private final List<JqlClause> clauses;

    private final List<EField> fields;
    
    private boolean fieldAll = false;
    
    private boolean fieldNavigable = false;
    
    public JqlSearchBean() {
		clauses = new ArrayList<JqlClause>();
		fields = new ArrayList<EField>();
	}

    public void addField(EField ... field){
        for (EField f : field) {
            getFields().add(f);
        }
    }
    
	public Integer getStartAt() {
		return startAt;
	}

	public void setStartAt(Integer startAt) {
		this.startAt = startAt;
	}

	public Integer getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}

	public List<JqlClause> getClauses() {
		return clauses;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(JqlClause c : clauses) {
			sb.append(c);
		}
		return sb.toString();
	}

	public List<EField> getFields() {
		return fields;
	}

    /**
     * Return all fields for a query.
     */
	public boolean isFieldAll() {
		return fieldAll;
	}

	public void setFieldAll(boolean fieldAll) {
		this.fieldAll = fieldAll;
	}
	
    /**
     * Return navigable fields for a query.
     */
	public boolean isFieldNavigable() {
		return fieldNavigable;
	}

	public void setFieldNavigable(boolean fieldNavigable) {
		this.fieldNavigable = fieldNavigable;
	}
}
