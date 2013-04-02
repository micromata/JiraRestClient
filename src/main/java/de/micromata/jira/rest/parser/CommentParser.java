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

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 08:37
 * To change this template use File | Settings | File Templates.
 */
public class CommentParser extends BaseParser {

	public static CommentBean parse(JsonObject object) {
		CommentBean bean = new CommentBean();
		parseBaseProperties(bean, object);
		String body = object.get(PROP_BODY).getAsString();
		UserBean au = UserParser.parse(object.get(ELEM_AUTHOR).getAsJsonObject());
		UserBean uau = UserParser.parse(object.get(ELEM_UPDATE_AUTHOR).getAsJsonObject());
		Date created = DateParser.parseDateFormat3(object.get(PROP_CREATED).getAsString());
		Date updated = DateParser.parseDateFormat3(object.get(PROP_UPDATED).getAsString());
		JsonElement element = object.get(ELEM_VISIBILITY);
		if(element != null) {
			VisibilityBean visibilityBean = VisibilityParser.parse(element.getAsJsonObject());
			bean.setVisibility(visibilityBean);
		}
		bean.setAuthor(au);
		bean.setUpdateAuthor(uau);
		bean.setBody(body);
		bean.setCreated(created);
		bean.setUpdated(updated);
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
