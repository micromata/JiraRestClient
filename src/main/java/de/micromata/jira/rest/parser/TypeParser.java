package de.micromata.jira.rest.parser;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.TypeBean;

public class TypeParser extends BaseParser {

	public static TypeBean parse(JsonObject object) {
		TypeBean bean = new TypeBean();
		parseBaseProperties(bean, object);
		String iw = object.get(PROP_INWARD).getAsString();
		String ow = object.get(PROP_OUTWARD).getAsString();
		bean.setInward(iw);
		bean.setOutward(ow);
		return bean;
	}

}
