package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.UserBean;
import de.micromata.jira.rest.domain.VisibilityBean;
import de.micromata.jira.rest.domain.WorklogBean;
import de.micromata.jira.rest.util.DateParser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

public class WorklogParser extends BaseParser {

	private static WorklogBean parse(JsonObject object) {
		WorklogBean bean = new WorklogBean();
		parseBaseProperties(bean, object);
		
		JsonElement authorElement = object.get(ELEM_AUTHOR);
		if(checkNotNull(authorElement)) {
			JsonObject obj = authorElement.getAsJsonObject();
			UserBean author = UserParser.parse(obj);
			bean.setAuthor(author);
		}
		
		JsonElement updateAuthorElement = object.get(ELEM_UPDATE_AUTHOR);
		if(checkNotNull(updateAuthorElement)) {
			JsonObject updateAuthorObj = updateAuthorElement.getAsJsonObject();
			UserBean updateAuthor = UserParser.parse(updateAuthorObj);
			bean.setUpdateAuthor(updateAuthor);
		}
		
		JsonElement commentElement = object.get(PROP_COMMENT);
		if(checkNotNull(commentElement)) {
			String com = commentElement.getAsString();
			bean.setComment(com);
		}
		
		JsonElement timeSpentElement = object.get(PROP_TIMESPENT);
		if(checkNotNull(timeSpentElement)) {
			String ts = timeSpentElement.getAsString();
			bean.setTimeSpent(ts);
		}
		
		JsonElement startedElement = object.get(PROP_STARTED);
		if(checkNotNull(startedElement)) {
			String d = startedElement.getAsString();
			Date date = DateParser.parseDateFormat1(d);
			bean.setStarted(date);
		}
		JsonElement timeSpentSecondsElement = object.get(PROP_TIME_SPENT_SECONDS);
		if(checkNotNull(timeSpentSecondsElement)) {
			long tss = timeSpentSecondsElement.getAsLong();
			bean.setTimeSpentSeconds(tss);
		}
		
		JsonElement visibilityElement = object.get(ELEM_VISIBILITY);
		if(checkNotNull(visibilityElement)) {
			JsonObject visibilityObj = visibilityElement.getAsJsonObject();
			VisibilityBean visibility = VisibilityParser.parse(visibilityObj);
			bean.setVisibility(visibility);
		}
		
		return bean;
	}
	
	public static List<WorklogBean> parse(List<JsonObject> objects) {
		List<WorklogBean> worklogs = new ArrayList<WorklogBean>();
		for(JsonObject o : objects) {
			WorklogBean web = parse(o);
			worklogs.add(web);
		}
		
		return worklogs;
	}


}
