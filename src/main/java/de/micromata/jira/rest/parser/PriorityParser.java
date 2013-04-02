package de.micromata.jira.rest.parser;

import java.net.URI;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.PriorityBean;
import de.micromata.jira.rest.util.URIParser;

public class PriorityParser extends BaseParser {

	public static PriorityBean parse(JsonObject object) {
		PriorityBean bean = new PriorityBean();
		parseBaseProperties(bean, object);
		String url = object.get(PROP_ICONURL).getAsString();
		URI uri = URIParser.parseStringToURI(url);
		bean.setIconUrl(uri);
		return bean;
	}

}
