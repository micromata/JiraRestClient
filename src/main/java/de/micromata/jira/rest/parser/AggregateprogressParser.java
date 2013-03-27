package de.micromata.jira.rest.parser;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.AggregateprogressBean;
import de.micromata.jira.rest.util.JsonConstants;

public class AggregateprogressParser implements JsonConstants {

	public static AggregateprogressBean parse(JsonObject object) {
		AggregateprogressBean bean = new AggregateprogressBean();
		int pr = object.get(ELEM_PROGRESS).getAsInt();
		int to = object.get(PROP_TOTAL).getAsInt();
		bean.setProgress(pr);
		bean.setTotal(to);
		return bean;
	}

}
