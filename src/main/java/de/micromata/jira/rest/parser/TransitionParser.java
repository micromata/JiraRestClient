package de.micromata.jira.rest.parser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.TransitionBean;
import de.micromata.jira.rest.util.URIParser;

public class TransitionParser extends BaseParser {

	public static TransitionBean parse(JsonObject object) {
		TransitionBean bean = new TransitionBean();
		parseBaseProperties(bean, object);
		
		JsonElement descriptionElement = object.get(PROP_DESCRIPTION);
		if(checkNotNull(descriptionElement)) {
			bean.setDescription(descriptionElement.getAsString());
		}
		JsonElement iconUrlElement = object.get(PROP_ICONURL);
		if(checkNotNull(iconUrlElement)) {
			String uri = iconUrlElement.getAsString();
			URI iconUrl = URIParser.parseStringToURI(uri);
			bean.setIconUrl(iconUrl);
		}
		JsonElement toElement = object.get(PROP_TO);
		if(checkNotNull(toElement)) {
			JsonObject toObject = toElement.getAsJsonObject();
			TransitionBean toBean = parse(toObject);
			bean.setTo(toBean);
		}
//		JsonElement fieldsElement = object.get(ELEM_FIELDS);
//		if(checkNotNull(fieldsElement)) {
//			JsonObject fieldsObject = fieldsElement.getAsJsonObject();
//			JsonElement assigneeElement = fieldsObject.get(ELEM_ASSIGNEE);
//			if(checkNotNull(assigneeElement)) {
//				JsonObject assigneeObject = assigneeElement.getAsJsonObject();
//				JsonElement requiredElement = assigneeObject.get(PROP_REQUIRED);
//				if(checkNotNull(requiredElement)) {
//					boolean assigneeRequired = requiredElement.getAsBoolean();
//					bean.setAssigneeRequired(assigneeRequired);
//				}
//			}
//		}
		
		return bean;
	}

	public static Map<Integer, TransitionBean> parse(List<JsonObject> list) {
		Map<Integer, TransitionBean> transitions = new HashMap<Integer, TransitionBean>();
		
		for(JsonObject o : list) {
			TransitionBean bean = parse(o);
			transitions.put((int) bean.getId(), bean);
		}
		
		return transitions;
	}
}
