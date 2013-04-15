package de.micromata.jira.rest.jql;

import java.util.ArrayList;
import java.util.List;

/**
 * JQL search requirements.
 */
public class JqlSearchBean {

	/** Result list start at. */
	private Integer startAt = null;

    /** Maximum result list size. */
    private Integer maxResult = null;
    
    /** JQL clause(s). */
    private List<JqlClause> clauses = null;

    /** Result fields for a query. */
    private List<EField> fields = null;
    
    /** Result for a query contains all fields. */
    private boolean fieldAll = false;
    
    /** Result for a query contains only navigable fields. */
    private boolean fieldNavigable = false;
    
    /**
     * Instantiates a new jql search bean.
     */
    public JqlSearchBean() {
		clauses = new ArrayList<JqlClause>();
		fields = new ArrayList<EField>();
	}

    /**
     * Adds fields which should be returned after the request.
     * 
     * @param fields = returned fields
     */
    public void addField(EField ... fields){
        for (EField f : fields) {
            getFields().add(f);
        }
    }
    
	/**
	 * Gets the start at.
	 *
	 * @return the start at
	 */
	public Integer getStartAt() {
		return startAt;
	}

	/**
	 * Sets the start at.
	 *
	 * @param startAt the new start at
	 */
	public void setStartAt(Integer startAt) {
		this.startAt = startAt;
	}

	/**
	 * Gets the max result.
	 *
	 * @return the max result
	 */
	public Integer getMaxResult() {
		return maxResult;
	}

	/**
	 * Sets the max result.
	 *
	 * @param maxResult the new max result
	 */
	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}

	/**
	 * Gets the clauses.
	 *
	 * @return the clauses
	 */
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

	/**
	 * Gets the fields.
	 *
	 * @return the fields
	 */
	public List<EField> getFields() {
		return fields;
	}

    /**
     * Return all fields after a request.
     *
     * @return true, if all fields should be returned
     */
	public boolean isFieldAll() {
		return fieldAll;
	}

	/**
	 * Sets the returned fields to all.
	 *
	 * @param fieldAll = true if all fields for query should be returned
	 */
	public void setFieldAll(boolean fieldAll) {
		this.fieldAll = fieldAll;
	}
	
    /**
     * Return navigable fields after a request.
     *
     * @return true, if navigable field should be returned
     */
	public boolean isFieldNavigable() {
		return fieldNavigable;
	}

	/**
	 * Sets the returned fields to navigable.
	 *
	 * @param fieldNavigable = true if navigable fields should be returned.
	 */
	public void setFieldNavigable(boolean fieldNavigable) {
		this.fieldNavigable = fieldNavigable;
	}

	/**
	 * Sets the clauses.
	 *
	 * @param clauses the new clauses
	 */
	public void setClauses(List<JqlClause> clauses) {
		this.clauses = clauses;
	}

	/**
	 * Sets the fields.
	 *
	 * @param fields the new fields
	 */
	public void setFields(List<EField> fields) {
		this.fields = fields;
	}
}
