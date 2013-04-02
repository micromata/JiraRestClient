package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.IssueBasicBean;
import de.micromata.jira.rest.domain.StatusBean;

public class IssueBasicParser extends BaseParser {

	public static IssueBasicBean parse(JsonObject object) {
		IssueBasicBean bean = new IssueBasicBean();
		parseBaseProperties(bean, object);
		String key = object.get(PROP_KEY).getAsString();
		bean.setKey(key);
		JsonElement fieldsElement = object.get(ELEM_FIELDS);
        if(fieldsElement != null){
        	object = fieldsElement.getAsJsonObject();
        	object = object.get(ELEM_STATUS).getAsJsonObject();
            StatusBean statusBean = StatusParser.parse(object);
            bean.setStatus(statusBean);
        }
        return bean;
	}

	
}
