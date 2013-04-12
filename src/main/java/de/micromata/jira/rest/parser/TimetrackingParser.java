package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.TimetrackingBean;
import de.micromata.jira.rest.util.JsonConstants;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

public class TimetrackingParser implements JsonConstants {

	public static TimetrackingBean parse(JsonObject object) {
		TimetrackingBean bean = new TimetrackingBean();
		
		JsonElement originalEstimateElement = object.get(PROP_ORIGINALESTIMATE);
		if(checkNotNull(originalEstimateElement)) {
			String s = originalEstimateElement.getAsString();
			bean.setOriginalEstimate(s);			
		}
		
		JsonElement remainingEstimateElement = object.get(PROP_REMAININGESTIMATE);
		if(checkNotNull(remainingEstimateElement)) {
			String s = remainingEstimateElement.getAsString();
			bean.setRemainingEstimate(s);
		}
		
		JsonElement timeSpentElement = object.get(PROP_TIMESPENT);
		if(checkNotNull(timeSpentElement)) {
			String s = timeSpentElement.getAsString();
			bean.setTimeSpent(s);
		}
		
		JsonElement timeSpentSecondsElement = object.get(PROP_TIME_SPENT_SECONDS);
		if(checkNotNull(timeSpentSecondsElement)) {
			int i = timeSpentSecondsElement.getAsInt();
			bean.setTimeSpentSeconds(i);
		}
		
		JsonElement originalEstimateSecondsElement = object.get(PROP_ORIGINAL_ESTIMATE_SECONDS);
		if(checkNotNull(originalEstimateSecondsElement)) {
			int i = originalEstimateSecondsElement.getAsInt();
			bean.setOriginalEstimateSeconds(i);
		}
		
		JsonElement remainingEstimateSocondsElement = object.get(PROP_REMAINING_ESTIMATE_SECONDS);
		if(remainingEstimateSocondsElement != null) {
			int i = remainingEstimateSocondsElement.getAsInt();
			bean.setRemainingEstimateSeconds(i);
		}
		return bean;
	}

}
