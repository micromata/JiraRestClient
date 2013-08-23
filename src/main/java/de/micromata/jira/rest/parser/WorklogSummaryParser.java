/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.parser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.WorklogBean;
import de.micromata.jira.rest.domain.WorklogSummaryBean;
import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.JsonConstants;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class WorklogSummaryParser implements JsonConstants {

	public static WorklogSummaryBean parse(JsonObject object) {
		WorklogSummaryBean bean = new WorklogSummaryBean();
		
		JsonElement startAtElement = object.get(PROP_STARTAT);
		if(checkNotNull(startAtElement)) {
			int sa = startAtElement.getAsInt();
			bean.setStartAt(sa);
		}
		
		JsonElement maxResultsElement = object.get(PROP_MAXRESULTS);
		if(checkNotNull(maxResultsElement)) {
			int mr = maxResultsElement.getAsInt();
			bean.setMaxResults(mr);
		}
		
		JsonElement totalElement = object.get(PROP_TOTAL);
		if(checkNotNull(totalElement)) {
			int to = totalElement.getAsInt();
			bean.setTotal(to);
		}
		
		JsonElement worklogsElement = object.get(PROP_WORKLOGS);
		if(checkNotNull(worklogsElement)) {
			JsonArray warray = worklogsElement.getAsJsonArray();
			List<JsonObject> list = GsonParserUtil.parseJsonArray(warray);
			List<WorklogBean> web = WorklogParser.parse(list);
			bean.setWorklogs(web);
		}
		
		return bean;
	}

}
