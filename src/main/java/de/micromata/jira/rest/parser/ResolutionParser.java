package de.micromata.jira.rest.parser;

import java.net.URI;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.ResolutionBean;
import de.micromata.jira.rest.util.URIParser;

public class ResolutionParser extends BaseParser {

	public static ResolutionBean parse(JsonObject object) {
		ResolutionBean bean = new ResolutionBean();
		parseBaseProperties(bean, object);
		String des = object.get(PROP_DESCRIPTION).getAsString();
		String iurl = object.get(PROP_ICONURL).getAsString();
		URI uri = URIParser.parseStringToURI(iurl);
		bean.setDescription(des);
		bean.setIconUrl(uri);
		return bean;
	}

}
