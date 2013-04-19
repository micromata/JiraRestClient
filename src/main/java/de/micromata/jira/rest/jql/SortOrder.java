package de.micromata.jira.rest.jql;

public enum SortOrder {

	ASC("asc"), DESC("desc");
	
	private String order;
	
	private SortOrder(String order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return this.order;
	}
}
