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

import de.micromata.jira.rest.domain.ProgressBean;
import de.micromata.jira.rest.util.JsonConstants;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class ProgressParser implements JsonConstants {

	public static ProgressBean parse(JsonObject object) {
		ProgressBean bean = new ProgressBean();
		
		JsonElement progressElement = object.get(ELEM_PROGRESS);
		if(checkNotNull(progressElement)) {
	        int progress = progressElement.getAsInt();
	        bean.setProgress(progress);
		}

		JsonElement totalElement = object.get(PROP_TOTAL);
		if(checkNotNull(totalElement)) {
			int total = totalElement.getAsInt();
	        bean.setTotal(total);
		}
        return bean;
	}

}
