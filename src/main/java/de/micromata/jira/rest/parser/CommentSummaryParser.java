/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.parser;

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.CommentBean;
import de.micromata.jira.rest.domain.CommentSummaryBean;
import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.JsonConstants;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class CommentSummaryParser implements JsonConstants {

	public static CommentSummaryBean parse(JsonObject object) {
		CommentSummaryBean bean = new CommentSummaryBean();
		
		JsonElement startAtElement = object.get(PROP_STARTAT);
		if(checkNotNull(startAtElement)) {
			int sa = startAtElement.getAsInt();
			bean.setStartAt(sa);
		}
		
		JsonElement totalElement = object.get(PROP_TOTAL);
		if(checkNotNull(totalElement)) {
			int to = totalElement.getAsInt();
			bean.setTotal(to);
		}
		
		JsonElement maxResultsElement = object.get(PROP_MAXRESULTS);
		if(checkNotNull(maxResultsElement)) {
			int mr = maxResultsElement.getAsInt();
			bean.setMaxResults(mr);
		}
		
		JsonElement commentsElement = object.get(PROP_COMMENTS);
		if(checkNotNull(commentsElement)) {
			List<JsonObject> list = GsonParserUtil.parseJsonArray(commentsElement.getAsJsonArray());
			List<CommentBean> comments = CommentParser.parse(list);
			bean.setComments(comments);
		}
		return bean;
	}

}
