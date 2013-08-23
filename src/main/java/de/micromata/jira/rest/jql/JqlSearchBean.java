/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.jql;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * JQL search requirements.
 *
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class JqlSearchBean {

	/** Result list start at. */
	private Integer startAt = null;

    /** Maximum result list size. */
    private Integer maxResults = null;

    /** Result fields for a query. */
    private List<String> fields = null;
    
    private String jql = StringUtils.EMPTY;

    /**
     * Adds fields which should be returned after the request.
     * 
     * @param fields = returned fields
     */
    public void addField(EField ... fields){
        for (EField f : fields) {
            getFields().add(f.toString());
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
	public Integer getMaxResults() {
		return maxResults;
	}

	/**
	 * Sets the max result.
	 *
	 * @param maxResult the new max result
	 */
	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}

	/**
	 * Gets the fields.
	 *
	 * @return the fields
	 */
	public List<String> getFields() {
		if(fields == null) {
			fields = new ArrayList<String>();
		}
		return fields;
	}

	public String getJql() {
		return jql;
	}

	public void setJql(String jql) {
		this.jql = jql;
	}
}
