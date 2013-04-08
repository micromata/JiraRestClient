package de.micromata.jira.rest.jql;

import java.util.ArrayList;
import java.util.List;

public class JqlBean2 {

	private Integer startAt = null;

    private Integer maxResult = null;
    
    private final List<JqlClause> clauses;
    
    public JqlBean2() {
		clauses = new ArrayList<JqlClause>();
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
}
