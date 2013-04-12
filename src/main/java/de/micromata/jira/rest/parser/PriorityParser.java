package de.micromata.jira.rest.parser;

import java.net.URI;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.PriorityBean;
import de.micromata.jira.rest.util.JsonElementUtil;
import de.micromata.jira.rest.util.URIParser;

public class PriorityParser extends BaseParser {

	public static PriorityBean parse(JsonObject object) {
		PriorityBean bean = new PriorityBean();
		parseBaseProperties(bean, object);
		
		JsonElement iconUrlElement = object.get(PROP_ICONURL);
		if(JsonElementUtil.checkNotNull(iconUrlElement)) {
			String url = iconUrlElement.getAsString();
			URI uri = URIParser.parseStringToURI(url);
			bean.setIconUrl(uri);
		}
		return bean;
	}

}
