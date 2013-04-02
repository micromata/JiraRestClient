package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.UserBean;
import de.micromata.jira.rest.domain.VisibilityBean;
import de.micromata.jira.rest.domain.WorklogBean;
import de.micromata.jira.rest.util.DateParser;

public class WorklogParser extends BaseParser {

	private static WorklogBean parse(JsonObject object) {
		WorklogBean bean = new WorklogBean();
		parseBaseProperties(bean, object);
		
		JsonObject obj = object.get(ELEM_AUTHOR).getAsJsonObject();
		UserBean author = UserParser.parse(obj);
		
		obj = object.get(ELEM_UPDATE_AUTHOR).getAsJsonObject();
		UserBean updateAuthor = UserParser.parse(obj);
		
		String com = object.get(PROP_COMMENT).getAsString();
		String ts = object.get(PROP_TIMESPENT).getAsString();
		String d = object.get(PROP_STARTED).getAsString();
		Date date = DateParser.parseDateFormat1(d);
		long tss = object.get(PROP_TIME_SPENT_SECONDS).getAsLong();
		
		obj = object.get(ELEM_VISIBILITY).getAsJsonObject();
		VisibilityBean visibility = VisibilityParser.parse(obj);
		
		bean.setAuthor(author);
		bean.setUpdateAuthor(updateAuthor);
		bean.setComment(com);
		bean.setVisibility(visibility);
		bean.setStarted(date);
		bean.setTimeSpentSeconds(tss);
		bean.setTimeSpent(ts);
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
