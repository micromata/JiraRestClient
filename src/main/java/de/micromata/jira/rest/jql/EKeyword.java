package de.micromata.jira.rest.jql;


public enum EKeyword {

	AND("and"),
	OR("or"),
	NOT("not"),
	EMPTY("empty"),
	NULL("null"),
	ORDER_BY("order by");
	
	private final String keyword;
	
	private EKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	@Override
	public String toString() {
		return getKeyword();
	}
}
