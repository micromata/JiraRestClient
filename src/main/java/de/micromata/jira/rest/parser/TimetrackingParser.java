package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.TimetrackingBean;
import de.micromata.jira.rest.util.JsonConstants;

public class TimetrackingParser implements JsonConstants {

	public static TimetrackingBean parse(JsonObject object) {
		TimetrackingBean bean = new TimetrackingBean();
		JsonElement jsonElement = object.get(PROP_ORIGINALESTIMATE);
		if(jsonElement != null) {
			String s = jsonElement.getAsString();
			bean.setOriginalEstimate(s);			
		}
		jsonElement = object.get(PROP_REMAININGESTIMATE);
		if(jsonElement != null) {
			String s = jsonElement.getAsString();
			bean.setRemainingEstimate(s);
		}
		jsonElement = object.get(PROP_TIMESPENT);
		if(jsonElement != null) {
			String s = jsonElement.getAsString();
			bean.setTimeSpent(s);
		}
		jsonElement = object.get(PROP_TIME_SPENT_SECONDS);
		if(jsonElement != null) {
			int i = jsonElement.getAsInt();
			bean.setTimeSpentSeconds(i);
		}
		jsonElement = object.get(PROP_ORIGINAL_ESTIMATE_SECONDS);
		if(jsonElement != null) {
			int i = jsonElement.getAsInt();
			bean.setOriginalEstimateSeconds(i);
		}
		jsonElement = object.get(PROP_REMAINING_ESTIMATE_SECONDS);
		if(jsonElement != null) {
			int i = jsonElement.getAsInt();
			bean.setRemainingEstimateSeconds(i);
		}
		return bean;
	}

}
