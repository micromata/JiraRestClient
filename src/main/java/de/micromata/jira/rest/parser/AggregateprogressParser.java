/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.AggregateprogressBean;
import de.micromata.jira.rest.util.JsonConstants;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class AggregateprogressParser implements JsonConstants {

	public static AggregateprogressBean parse(JsonObject object) {
		AggregateprogressBean bean = new AggregateprogressBean();
		
		JsonElement progressElement = object.get(ELEM_PROGRESS);
		if(checkNotNull(progressElement)) {
			int pr = progressElement.getAsInt();
			bean.setProgress(pr);
		}

		JsonElement totalElement = object.get(PROP_TOTAL);
		if(checkNotNull(totalElement)) {
			int to = totalElement.getAsInt();
			bean.setTotal(to);
		}
		return bean;
	}

}
