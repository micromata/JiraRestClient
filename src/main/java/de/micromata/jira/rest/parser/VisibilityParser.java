package de.micromata.jira.rest.parser;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.VisibilityBean;
import de.micromata.jira.rest.util.JsonConstants;

public class VisibilityParser implements JsonConstants {

	public static VisibilityBean parse(JsonObject obj) {
		VisibilityBean bean = new VisibilityBean();
		String ty = obj.get(PROP_TYPE).getAsString();
		String va = obj.get(PROP_VALUE).getAsString();
		bean.setType(ty);
		bean.setValue(va);
		return bean;
	}

}
