package de.micromata.jira.rest.jql;

public enum EField {

	AFFECTED_VERSION("affectedVersion"),
	ASSIGNEE("assignee"),
	CATEGORY("category"),
	COMMENT("comment"),
	COMPONENT("component"),
	CREATED("created"),
//	CUSTOM_FIELD("CustomFieldName"),
	DESCRIPTION("description"),
	DUE("due"),
	ENVIRONMENT("environment"),
	EPIC_LINKS("epic link"),
	FILTER("filter"),
	FIX_VERSION("fixVersion"),
	ISSUE_KEY("issueKey"),
	LAST_VIEWED("lastViewed"),
	LEVEL("level"),
	ORIGINAL_ESTIMATE("originalEstimate"),
	PARENT("parent"),
	PRIORITY("priority"),
	PROJECT("project"),
	REMAINING_ESTIMATE("remainingEstimate"),
	REPORTER("reporter"),
	RESOLUTION("resolution"),
	RESOLVED("resolved"),
	SPRINT("sprint"),
	STATUS("status"),
	SUMMARY("summary"),
	TEXT("text"),
	TYPE("type"),
	TIME_SPENT("timeSpent"),
	UPDATED("updated"),
	VOTER("voter"),
	VOTES("votes"),
	WATCHER("watcher"),
	WATCHERS("watchers"),
	WORK_RATIO("workRatio");
	
	private final String field;
	
	private EField(String field) {
		this.field = field;
	}

	public String getField() {
		return field;
	}

	@Override
	public String toString() {
		return getField();
	}
}
