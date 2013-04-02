package de.micromata.jira.rest.parser;

import java.util.List;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.CommentBean;
import de.micromata.jira.rest.domain.CommentSummaryBean;
import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.JsonConstants;

public class CommentSummaryParser implements JsonConstants {

	public static CommentSummaryBean parse(JsonObject object) {
		CommentSummaryBean bean = new CommentSummaryBean();
		int sa = object.get(PROP_STARTAT).getAsInt();
		int to = object.get(PROP_TOTAL).getAsInt();
		int mr = object.get(PROP_MAXRESULTS).getAsInt();
		List<JsonObject> list = GsonParserUtil.parseJsonArray(object.getAsJsonArray(PROP_COMMENTS));
		List<CommentBean> comments = CommentParser.parse(list);
		bean.setComments(comments);
		bean.setMaxResults(mr);
		bean.setStartAt(sa);
		bean.setTotal(to);
		return bean;
	}

}
