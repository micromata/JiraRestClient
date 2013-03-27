package de.micromata.jira.rest.parser;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.WorklogBean;
import de.micromata.jira.rest.domain.WorklogSummaryBean;
import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.JsonConstants;

public class WorklogSummaryParser implements JsonConstants {

	public static WorklogSummaryBean parse(JsonObject object) {
		WorklogSummaryBean bean = new WorklogSummaryBean();
		int sa = object.get(PROP_STARTAT).getAsInt();
		int mr = object.get(PROP_MAXRESULTS).getAsInt();
		int to = object.get(PROP_TOTAL).getAsInt();
		JsonArray warray = object.get(PROP_WORKLOGS).getAsJsonArray();
		List<JsonObject> list = GsonParserUtil.parseJsonArray(warray);
		List<WorklogBean> web = WorklogParser.parse(list);
		bean.setStartAt(sa);
		bean.setMaxResults(mr);
		bean.setTotal(to);
		bean.setWorklogs(web);
		return bean;
	}

}
