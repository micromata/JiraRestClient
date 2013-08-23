/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.CommentBean;
import de.micromata.jira.rest.domain.UserBean;
import de.micromata.jira.rest.domain.VisibilityBean;
import de.micromata.jira.rest.util.DateParser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class CommentParser extends BaseParser {

	public static CommentBean parse(JsonObject object) {
		CommentBean bean = new CommentBean();
		parseBaseProperties(bean, object);
		
		JsonElement bodyElement = object.get(PROP_BODY);
		if(checkNotNull(bodyElement)) {
			String body = bodyElement.getAsString();
			bean.setBody(body);
		}

		JsonElement authorElement = object.get(ELEM_AUTHOR);
		if(checkNotNull(authorElement)) {
			UserBean au = UserParser.parse(authorElement.getAsJsonObject());
			bean.setAuthor(au);
		}
		
		JsonElement updateAuthorElement = object.get(ELEM_UPDATE_AUTHOR);
		if(checkNotNull(updateAuthorElement)) {
			UserBean uau = UserParser.parse(updateAuthorElement.getAsJsonObject());
			bean.setUpdateAuthor(uau);
		}
		
		JsonElement createdElement = object.get(PROP_CREATED);
		if(checkNotNull(createdElement)) {
			Date created = DateParser.parseDateFormat(createdElement.getAsString(), DateParser.Format.YYYY_MM_DD_T_HH_MM_SS_SSSZ);
			bean.setCreated(created);
		}
		
		JsonElement updatedElement = object.get(PROP_UPDATED);
		if(checkNotNull(updatedElement)) {
			Date updated = DateParser.parseDateFormat(updatedElement.getAsString(), DateParser.Format.YYYY_MM_DD_T_HH_MM_SS_SSSZ);
			bean.setUpdated(updated);
		}

		JsonElement visibilityElement = object.get(ELEM_VISIBILITY);
		if(checkNotNull(visibilityElement)) {
			VisibilityBean visibilityBean = VisibilityParser.parse(visibilityElement.getAsJsonObject());
			bean.setVisibility(visibilityBean);
		}
		return bean;
	}
	
	public static List<CommentBean> parse(List<JsonObject> objects) {
		List<CommentBean> list = new ArrayList<CommentBean>();
		for(JsonObject o : objects) {
			CommentBean bean = parse(o);
			list.add(bean);
		}
		return list;
	}
}
