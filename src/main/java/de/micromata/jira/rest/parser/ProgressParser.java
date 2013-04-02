package de.micromata.jira.rest.parser;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.ProgressBean;
import de.micromata.jira.rest.util.JsonConstants;

public class ProgressParser implements JsonConstants {

	public static ProgressBean parse(JsonObject object) {
		ProgressBean bean = new ProgressBean();
        int progress = object.get(ELEM_PROGRESS).getAsInt();
        int total = object.get(PROP_TOTAL).getAsInt();
        bean.setProgress(progress);
        bean.setTotal(total);
        return bean;
	}

}
